package br.com.fundatec.myapplication.profile.data.remote

import android.util.Log
import br.com.fundatec.myapplication.profile.data.response.UserResponse
import br.com.fundatec.myapplication.webservice.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteUserDatasource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(UserApi::class.java)

    suspend fun createUser(name: String, email: String, password: String): UserResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val userResponse = service.create(UserRequest(name, email, password))
                if (userResponse.isSuccessful) {
                    userResponse.body()
                } else {
                    null
                }
            } catch (ex: Exception) {
                Log.e("UserDataSource", ex.message ?: "usuario não encontrado")
                null
            }
        }
    }
}