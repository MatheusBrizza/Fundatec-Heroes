package br.com.fundatec.myapplication.character.data

import android.widget.Spinner
import br.com.fundatec.myapplication.character.response.CharacterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {

    @GET("api/character")
    suspend fun listCharacter(
        @Query("name") name: String,
        @Query("description") description: String,
        @Query("image") image: String,
        @Query("universeType") universeType: Spinner,
        @Query("characterType") characterType: Spinner,
        @Query("age") age: Int,
        @Query("date") date: String
    )

    @POST("api/character")
    suspend fun saveCharacter(
        @Path("id") characterId: Int,
//        @Body character: CharacterRequest
    ) : Response<CharacterResponse>
}