package br.com.fundatec.myapplication.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.fundatec.myapplication.R
import br.com.fundatec.myapplication.databinding.FragmentCharacterBinding

private const val ARG_PARAM1 = "param1"

class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.run {
            binding.tvName.text = getString(ARG_PARAM1)
        }
    }

    companion object {
         fun newInstance(param1: String) =
            CharacterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}