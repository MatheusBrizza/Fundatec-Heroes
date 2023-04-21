package br.com.fundatec.myapplication.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import br.com.fundatec.myapplication.character.data.HeroVillain
import br.com.fundatec.myapplication.character.data.response.CharacterResponse
import br.com.fundatec.myapplication.databinding.FragmentCharacterBinding
import br.com.fundatec.myapplication.home.presentation.CharacterFragmentViewModel
import br.com.fundatec.myapplication.home.presentation.ViewState


class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private val adapter by lazy {
        ListItemAdapter()
    }
    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(CharacterFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.ShowCharacterList -> addItems(state.characterList)
                is ViewState.ShowListEmpty -> recyclerVazio()
                is ViewState.Loading -> loading()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        init()
    }

    private fun init() {
        val bundle = arguments?.getString("heroType")
        viewModel.populateRecyclerView(HeroVillain.valueOf(bundle.orEmpty()))
    }

    private fun loading() {
        binding.pbLoading.isVisible = true
    }

    private fun addItems(characterList: List<CharacterResponse>) {
        binding.pbLoading.isVisible = false
        adapter.setItems(characterList)
    }

    private fun recyclerVazio() {
        binding.pbLoading.isVisible = false
        Toast.makeText(requireContext(), "Recycler está vazio.", Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance(hv: HeroVillain): Fragment {
            return CharacterFragment().apply {
                val bundle = Bundle()
                bundle.putString("heroType", hv.name)
                arguments = bundle
            }
        }
    }
}