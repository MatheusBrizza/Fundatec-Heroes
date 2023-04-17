package br.com.fundatec.myapplication.character.data.repository

import br.com.fundatec.myapplication.character.data.local.CharacterLocalDatasource
import java.util.*

class CharacterRepository {

    private val localDatasource: CharacterLocalDatasource by lazy {
        CharacterLocalDatasource()
    }

    suspend fun saveCharacterDB(
        apiId: Int, name: String, url: String, description: String,
        marvelDc: String, heroiVilao: String, age: Int, birthday: String?
    ) {
        localDatasource.saveCharacter(
            apiId, name, url, description,
            marvelDc, heroiVilao, age, birthday
        )
    }

}