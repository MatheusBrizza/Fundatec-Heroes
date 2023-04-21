package br.com.fundatec.myapplication.profile.domain.usecase


import android.util.Log
import br.com.fundatec.myapplication.login.data.remote.RemoteLoginDataSource
import br.com.fundatec.myapplication.profile.data.local.LocalDatasource
import br.com.fundatec.myapplication.profile.data.local.User
import br.com.fundatec.myapplication.profile.data.remote.RemoteUserDatasource
import br.com.fundatec.components.showToast


class UserUsecase {
    private val remoteLoginDataSource: RemoteLoginDataSource by lazy {
        RemoteLoginDataSource()
    }

    private val remoteUserDatasource: RemoteUserDatasource by lazy {
        RemoteUserDatasource()
    }

    private val localDatasource: LocalDatasource by lazy {
        LocalDatasource()
    }

    suspend fun saveUserLocalAfterLogin(email: String, password: String) {
        val loginResponse = remoteLoginDataSource.login(email, password)
            val user = loginResponse?.let {
                User(
                    it.id,
                    loginResponse.name,
                    loginResponse.email,
                    loginResponse.password
                )
            }
        // TODO: validação de existência de usuário na API
            localDatasource.saveUser(user!!)

    }

    suspend fun saveNewProfile(name: String, email: String, password: String) {
        remoteUserDatasource.createUser(name, email, password)
    }

    fun getUserId(): Int {
        return localDatasource.getUserId()
    }
}