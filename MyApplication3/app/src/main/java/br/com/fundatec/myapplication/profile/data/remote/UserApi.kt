package br.com.fundatec.myapplication.profile.data.remote

import br.com.fundatec.myapplication.profile.data.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("api/login")
    suspend fun create(
        @Body userRequest: UserRequest
    ): Response<UserResponse?>
}