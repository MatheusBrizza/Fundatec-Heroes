package br.com.fundatec.myapplication.character.data.remote

import android.util.Log
import br.com.fundatec.myapplication.character.data.request.CharacterRequest
import br.com.fundatec.myapplication.character.data.response.CharacterResponse
import br.com.fundatec.myapplication.webservice.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Date

class RemoteCharacterDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(CharacterApi::class.java)

     suspend fun getListAll(userId: Int): List<CharacterResponse> {
            try {
                val characterResponse = service.getAllCharacters(userId)
                if (characterResponse.isSuccessful) {
                    Log.e("CharacterDataSource", "body from response: " + "${characterResponse.body()}")
                    return characterResponse.body()!!
                } else {
                    return listOf()
                }
            } catch (ex: Exception) {
                Log.e("CharacterDataSource", ex.message ?: "personagem não salvo")
                return listOf()
            }
    }

    suspend fun saveCharacterApi(userId: Int, name: String, description: String, image: String,
                                universeType: String, characterType: String, age: Int, birthday: String?
    ): Int? {
        return withContext(Dispatchers.IO) {
            try {
                val userResponse = service.saveCharacter(userId, CharacterRequest(name, description
                    , image, universeType, characterType, age, birthday)
                )
                if (userResponse.isSuccessful) {
                    userResponse.body()
                } else {
                    null
                }
            } catch (ex: Exception) {
                Log.e("CharacterDataSource", ex.message ?: "personagem não salvo")
                null
            }
        }
    }
}