package br.com.fundatec.myapplication.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.fundatec.myapplication.character.data.HeroVillain
import br.com.fundatec.myapplication.character.data.response.CharacterResponse
import br.com.fundatec.myapplication.databinding.FragmentCharacterBinding
import br.com.fundatec.myapplication.home.presentation.CharacterFragmentViewModel
import br.com.fundatec.myapplication.home.presentation.ViewState


class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private val adapter by lazy{
        ListItemAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel = CharacterFragmentViewModel()
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        val bundle = arguments?.getString("heroType")
        viewModel.populateRecyclerView(HeroVillain.valueOf(bundle.orEmpty()))
        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            when(state) {
                is ViewState.ShowCharacterList -> addItems(state.characterList)
                is ViewState.ShowListEmpty -> recyclerVazio()
            }
        }
    }

    private fun addItems(characterList: List<CharacterResponse>){
        adapter.setItems(characterList)
    }

    private fun recyclerVazio(){
        Toast.makeText(requireContext(), "Recycler está vazio.", Toast.LENGTH_LONG).show()
    }

    companion object {
         fun newInstance(hv: HeroVillain): Fragment{
             return CharacterFragment().apply {
                 val bundle = Bundle()
                 bundle.putString("heroType", hv.name)
                 arguments = bundle
             }
         }
    }
}