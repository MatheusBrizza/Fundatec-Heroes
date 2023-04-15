package br.com.fundatec.myapplication.character.view

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.myapplication.App
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import br.com.fundatec.myapplication.character.data.Character

class CharacterViewModel : ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    private val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    fun validateUserInput(
        name: String?, description: String?, heroiVilao: String?,
        marvelDc: String?, age: String?, date: String?, url: String?
    ) {
        if (name.isNullOrEmpty() || description.isNullOrEmpty() || heroiVilao.isNullOrEmpty() ||
            marvelDc.isNullOrEmpty() || age.isNullOrEmpty() || date.isNullOrEmpty() ||
            url.isNullOrEmpty()
        ) {
            state.value = ViewState.ShowError
        } else {
            val character = Character(name, url, description, enumValueOf(marvelDc),
                enumValueOf(heroiVilao), age, date)
            val characterString = moshi.adapter(Character::class.java).toJson(character)
            save(characterString)
            state.value = ViewState.ShowCharacter
        }
    }

    private fun save(characterString: String) {
        val preferences = App.context
            .getSharedPreferences("bd", AppCompatActivity.MODE_PRIVATE)
        preferences.edit().putString("character", characterString).commit()
    }
}

sealed class ViewState {
    object ShowCharacter : ViewState()
    object ShowError : ViewState()
}