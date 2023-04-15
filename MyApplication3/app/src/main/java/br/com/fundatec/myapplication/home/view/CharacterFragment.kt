package br.com.fundatec.myapplication.home.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.fundatec.myapplication.App
import br.com.fundatec.myapplication.databinding.FragmentCharacterBinding
import br.com.fundatec.myapplication.character.data.Character
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding

    private val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
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
        val adapter = ListItemAdapter()
        binding.list.adapter = adapter

        val preferences = App.context.getSharedPreferences("bd", Context.MODE_PRIVATE)

        val characterString = preferences.getString("character", "")
        if (characterString.isNullOrBlank()) {
            toastRecyclerVazio()
        } else {
            val characterFromPreferences: Character = moshi.adapter(Character::class.java)
                .fromJson(characterString)!!
            adapter.setItems(characterFromPreferences)
        }
    }

    private fun toastRecyclerVazio() {
        Toast.makeText(requireContext(), "Recycler está vazio.", Toast.LENGTH_LONG).show()
    }
    companion object {
         fun newInstance() = CharacterFragment()
    }
}