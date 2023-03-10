package br.com.fundatec.myapplication.character.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate

class CharacterViewModel : ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    fun validateUserInput(name: String?, description: String?, age: String?, date: String?, url: String?) {
        if (name.isNullOrEmpty() || description.isNullOrEmpty() ||
            age.isNullOrEmpty() || date.isNullOrEmpty() || url.isNullOrEmpty()) {
            state.value = ViewState.ShowError
        }
        else {
            state.value = ViewState.ShowCharacter
            //TODO: shared preferences vai aqui
        }
    }
}

sealed class ViewState {
    object ShowCharacter : ViewState()
    object ShowError : ViewState()
}