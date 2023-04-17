package br.com.fundatec.myapplication.character.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.myapplication.character.domain.usecase.CharacterUsecase
import br.com.fundatec.myapplication.profile.domain.usecase.UserUsecase
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    private val characterUseCase: CharacterUsecase by lazy {
        CharacterUsecase()
    }

    private val userUseCase: UserUsecase by lazy {
        UserUsecase()
    }

    fun validateUserInput(
        name: String?, description: String?, url: String?, heroiVilao: String?,
        marvelDc: String?, age: String?, birthday: String?
    ) {
        viewModelScope.launch {
            state.value = ViewState.Loading
            if (name.isNullOrEmpty() || description.isNullOrEmpty() || url.isNullOrEmpty() ||
                heroiVilao.isNullOrEmpty() || marvelDc.isNullOrEmpty() || age.isNullOrEmpty()
            ) {
                state.value = ViewState.ShowError
            } else {
                val idUser = userUseCase.getUserId()
                characterUseCase.saveCharacter(
                    idUser, name, description, url, marvelDc,
                    heroiVilao, age.toInt(), birthday
                )
                state.value = ViewState.ShowCharacter
            }
        }
    }


}

sealed class ViewState {
    object ShowCharacter : ViewState()
    object ShowError : ViewState()
    object Loading : ViewState()
}