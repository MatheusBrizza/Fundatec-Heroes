package br.com.fundatec.myapplication.character.data.local

import android.util.Log
import br.com.fundatec.myapplication.database.FHDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import br.com.fundatec.myapplication.character.data.local.CharacterEntity.*

class CharacterLocalDatasource {
    private val database: FHDatabase by lazy {
        FHDatabase.getInstance()
    }

    suspend fun saveCharacter(
        apiId: Int, name: String, description: String, url: String,
        marvelDc: String, heroiVilao: String, age: Int, birthday: String?
    ) {
        return withContext(Dispatchers.IO) {
            database.characterDao().insertCharacter(
                CharacterEntity(
                    apiId = apiId,
                    name = name,
                    description = description,
                    image = url,
                    universeType = marvelDC.valueOf(marvelDc),
                    characterType = heroVillain.valueOf(heroiVilao),
                    age = age,
                    birthday = birthday
                )
            )
            Log.e("characters list", "${database.characterDao().getCharacters()}")
        }
    }
}