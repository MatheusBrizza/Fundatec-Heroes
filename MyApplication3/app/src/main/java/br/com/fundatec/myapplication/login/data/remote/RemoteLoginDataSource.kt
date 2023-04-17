package br.com.fundatec.myapplication.login.data.remote

import android.util.Log
import br.com.fundatec.myapplication.login.data.response.LoginResponse
import br.com.fundatec.myapplication.webservice.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteLoginDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(LoginApi::class.java)

    suspend fun login(email: String, password: String): LoginResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val loginResponse = service.login(email = email, password = password)
                if (loginResponse.isSuccessful) {
                    loginResponse.body()
                } else {
                    null
                }
            } catch (ex: Exception) {
                Log.e("LoginDataSource", ex.message ?: "usuario não encontrado")
                null
            }
        }
    }
}