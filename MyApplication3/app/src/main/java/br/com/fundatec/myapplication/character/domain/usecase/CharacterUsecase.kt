package br.com.fundatec.myapplication.character.domain.usecase

import br.com.fundatec.myapplication.character.data.remote.RemoteCharacterDataSource
import br.com.fundatec.myapplication.character.data.repository.CharacterRepository
import br.com.fundatec.myapplication.character.data.response.CharacterResponse
import java.util.*

class CharacterUsecase {

    private val repository: CharacterRepository by lazy {
        CharacterRepository()
    }

    private val remoteCharacterDataSource: RemoteCharacterDataSource by lazy {
        RemoteCharacterDataSource()
    }

    suspend fun listAll(id: Int): List<CharacterResponse> {
        return remoteCharacterDataSource.getListAll(id)

    }

    suspend fun saveCharacter(
        userId: Int, name: String, url: String, description: String,
        marvelDc: String, heroiVilao: String, age: Int, birthday: String?
    ) {
        remoteCharacterDataSource.saveCharacterApi(
            userId, name, url, description,
            marvelDc, heroiVilao, age, birthday
        )

    }
}