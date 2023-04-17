package br.com.fundatec.myapplication.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.components.EmailValidator
import br.com.fundatec.myapplication.profile.domain.usecase.UserUsecase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    private val usecase: UserUsecase by lazy {
        UserUsecase()
    }

    fun validateAndSaveUserInput(email: String?, password: String?) {
        viewModelScope.launch {
            state.value = ViewState.Loading
            if (email.isNullOrEmpty() && password.isNullOrEmpty()) {
                state.value = ViewState.ShowErrorFields
            } else if (email?.let { EmailValidator.isEmailValid(email) } == false) {
                state.value = ViewState.ShowErrorEmail
            } else if (password.isNullOrEmpty() || password.length < 6) {
                state.value = ViewState.ShowErrorPassword
            } else {
                usecase.saveUserLocalAfterLogin(email!!, password)
                state.value = ViewState.ShowSuccess
            }
        }
    }

}

sealed class ViewState {
    object ShowSuccess : ViewState()
    object ShowErrorFields : ViewState()
    object ShowErrorEmail : ViewState()
    object ShowErrorPassword : ViewState()
    object Loading : ViewState()
}