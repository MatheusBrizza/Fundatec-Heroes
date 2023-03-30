package br.com.fundatec.myapplication.profile.data.local

import android.util.Log
import br.com.fundatec.myapplication.database.FHDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDatasource {
    private val database: FHDatabase by lazy {
        FHDatabase.getInstance()
    }


    suspend fun save() {
        return withContext(Dispatchers.IO) {
            database.userDao().insertUser(
                UserEntity(
                    name = "Matheus",
                    email = "matheus.brizola@gmail.com",
                    password = "123456"
                )
            )

            Log.e("teste", "${database.userDao().getUser()}")
        }
    }

}