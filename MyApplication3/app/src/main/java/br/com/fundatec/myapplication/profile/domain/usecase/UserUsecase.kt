package br.com.fundatec.myapplication.profile.domain.usecase

import br.com.fundatec.myapplication.profile.data.repository.UserRepository

class UserUsecase {

    private val repository: UserRepository by lazy {
        UserRepository()
    }

    suspend fun saveUser() {
        repository.saveUser()
    }
}