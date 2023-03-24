package br.com.fundatec.myapplication.profile.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insertUser(UserEntity: UserEntity)

    @Query("SELECT * from userTable")
    fun getUser(): List<UserEntity>
}