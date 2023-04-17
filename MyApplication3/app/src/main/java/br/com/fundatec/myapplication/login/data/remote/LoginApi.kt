package br.com.fundatec.myapplication.login.data.remote

import br.com.fundatec.myapplication.login.data.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginApi {

    @GET("api/login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String,
    ): Response<LoginResponse?>
}