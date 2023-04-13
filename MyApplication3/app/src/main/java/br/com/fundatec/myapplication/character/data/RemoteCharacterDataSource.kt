package br.com.fundatec.myapplication.character.data

import br.com.fundatec.myapplication.webservice.RetrofitNetworkClient

class RemoteCharacterDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(CharacterApi::class.java)

//    suspend fun character()
}