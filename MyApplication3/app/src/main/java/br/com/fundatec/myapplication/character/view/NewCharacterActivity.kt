package br.com.fundatec.myapplication.character.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import br.com.fundatec.components.showSnack
import br.com.fundatec.myapplication.R
import br.com.fundatec.myapplication.databinding.ActivityNewCharacterBinding
import br.com.fundatec.myapplication.home.view.HomeActivity


class NewCharacterActivity : AppCompatActivity(), OnItemSelectedListener {
    private lateinit var binding: ActivityNewCharacterBinding
    private val viewModel: CharacterViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configSpinner(R.array.marca, binding.spnMarvelDc)
        configSpinner(R.array.heroi_vilao, binding.spnHeroVilain)
        configSaveCharacterButton()
        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowCharacter -> saveCharacter()
                is ViewState.ShowError -> showError()
                is ViewState.Loading -> loading()
            }
        }

    }

    private fun configSpinner(list: Int, view: Spinner) {
        binding.spnHeroVilain.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            view.adapter = adapter
        }
    }

    private fun configSaveCharacterButton() {
        binding.btnSaveCharacter.setOnClickListener {
            viewModel.validateUserInput(
                name = binding.tietName.text.toString(),
                url = binding.tietUrl.text.toString(),
                description = binding.tietDescription.text.toString(),
                heroiVilao = binding.spnHeroVilain.getSelectedItem().toString(),
                marvelDc = binding.spnMarvelDc.getSelectedItem().toString(),
                age = binding.tietAge.text.toString(),
                birthday = binding.tietDate.text.toString()
            )
        }
    }

    private fun loading() {
        binding.pbLoading.isVisible = true
    }

    private fun showError() {
        binding.pbLoading.isVisible = false
        showSnack(binding.root, "campos não podem estar vazios")
    }

    private fun saveCharacter() {
        binding.pbLoading.isVisible = false
        showSnack(binding.root, "personagem salvo")
        val intent = Intent(this@NewCharacterActivity, HomeActivity::class.java)
        startActivity(intent)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

}

