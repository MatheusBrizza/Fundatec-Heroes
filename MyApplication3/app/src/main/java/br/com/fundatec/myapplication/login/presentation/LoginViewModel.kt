package br.com.fundatec.myapplication.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.components.EmailValidator

class LoginViewModel : ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    fun validateUserInput(email: String?, password: String?) {
        if (email.isNullOrEmpty() && password.isNullOrEmpty()) {
            state.value = ViewState.ShowErrorFields
        } else if (email?.let { EmailValidator.isEmailValid(email) } == false) {
            state.value = ViewState.ShowErrorEmail
        } else if (password.isNullOrEmpty() || password.length < 6) {
            state.value = ViewState.ShowErrorPassword
        } else {
            state.value = ViewState.ShowHome
        }
    }

}

sealed class ViewState {
    object ShowHome : ViewState()
    object ShowErrorFields : ViewState()
    object ShowErrorEmail : ViewState()
    object ShowErrorPassword : ViewState()
}