package br.com.fundatec.myapplication.profile.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name: String,
    val email: String,
    val password: String
)
