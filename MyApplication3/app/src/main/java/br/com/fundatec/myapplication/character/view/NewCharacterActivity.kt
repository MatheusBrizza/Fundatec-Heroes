package br.com.fundatec.myapplication.character.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.fundatec.myapplication.R
import br.com.fundatec.myapplication.databinding.ActivityNewCharacterBinding
import com.google.android.material.snackbar.Snackbar
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class NewCharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewCharacterBinding
    private val viewModel: CharacterViewModel by viewModels()
    private val character by lazy {
    }

    private val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configSpinner(R.array.marca, binding.spnMarvelDc)
        configSpinner(R.array.heroi_vilao, binding.spnHeroVilain)
        configCharacterButton()
        viewModel.viewState.observe(this) { state ->
            when(state) {
                is ViewState.ShowCharacter -> showCharacter()
                is ViewState.ShowError -> showSnack()
            }
        }

    }

    private fun configSpinner( list: Int, view: Spinner) {
        ArrayAdapter.createFromResource(
            this,
            list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            view.adapter = adapter
        }
    }

    private fun configCharacterButton() {
        binding.btnSaveCharacter.setOnClickListener {
            viewModel.validateUserInput(
                name = binding.tietName.text.toString(),
                description = binding.tietDescription.text.toString(),
                age = binding.tietAge.text.toString(),
                date = binding.tietDate.text.toString(),
                url = binding.tietUrl.text.toString()
            )
        }
    }

    private fun showSnack() {
        val container = findViewById<ConstraintLayout>(R.id.char_container)
        Snackbar
            .make(container, "Preencher todos os campos", Snackbar.LENGTH_LONG)
            .setAction("OK") {
                showCharacter()
            }
            .show()
    }

    private fun showCharacter() {
        val preferences = getSharedPreferences("bd", MODE_PRIVATE)
        val characterString = moshi.adapter(Character::class.java)
                                    .toJson(Character("null", "null", "null",
                                        "null", "null", dcMarvel = Spinner(this), heroVilan = Spinner(this)))
        preferences.edit().putString("character", characterString).commit()
    }

}

data class Character(
    val name: String,
    val description: String,
    val age: String,
    val date: String,
    val url: String,
    val dcMarvel: Spinner,
    val heroVilan: Spinner,
)