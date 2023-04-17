package br.com.fundatec.myapplication.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.components.EmailValidator
import br.com.fundatec.myapplication.profile.domain.usecase.UserUsecase
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    private val usecase: UserUsecase by lazy {
        UserUsecase()
    }

    fun validateUserInput(name: String?, email: String?, password: String?) {
        viewModelScope.launch {
            state.value = ViewState.Loading
            if (name.isNullOrEmpty() && email.isNullOrEmpty() && password.isNullOrEmpty()) {
                state.value = ViewState.ShowError
            } else if (name.isNullOrEmpty()) {
                state.value = ViewState.ShowErrorName
            } else if (email?.let { EmailValidator.isEmailValid(email) } == false) {
                state.value = ViewState.ShowErrorEmail
            } else if (password.isNullOrEmpty() || password.length < 6) {
                state.value = ViewState.ShowErrorPassword
            } else {
                usecase.saveNewProfile(name, email!!, password)
                state.value = ViewState.ShowSuccess
            }
        }
    }
}

sealed class ViewState {
    object ShowSuccess : ViewState()
    object ShowError : ViewState()
    object ShowErrorName : ViewState()
    object ShowErrorEmail : ViewState()
    object ShowErrorPassword : ViewState()
    object Loading: ViewState()
}