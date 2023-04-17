package br.com.fundatec.myapplication.character.data.remote

import br.com.fundatec.myapplication.character.data.request.CharacterRequest
import br.com.fundatec.myapplication.character.data.response.CharacterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CharacterApi {

    @GET("api/character/{userId}")
    suspend fun getAllCharacters(
        @Path("userId") userId: Int,
    ) : Response<List<CharacterResponse>>

    @POST("api/character/{userId}")
    suspend fun saveCharacter(
        @Path("userId") userId: Int,
        @Body character: CharacterRequest
    ) : Response<Int?>
}