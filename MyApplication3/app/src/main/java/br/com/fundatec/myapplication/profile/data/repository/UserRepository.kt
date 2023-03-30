package br.com.fundatec.myapplication.profile.data.repository

import br.com.fundatec.myapplication.profile.data.local.LocalDatasource

class UserRepository {

    private val localDatasource: LocalDatasource by lazy {
        LocalDatasource()
    }

    suspend fun saveUser() {
        localDatasource.save()
    }
}