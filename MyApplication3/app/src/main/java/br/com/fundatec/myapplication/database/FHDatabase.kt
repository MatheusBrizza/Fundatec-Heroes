package br.com.fundatec.myapplication.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fundatec.myapplication.profile.data.local.UserDao
import br.com.fundatec.myapplication.profile.data.local.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class FHDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(): FHDatabase {
            return Room.databaseBuilder(
                App.context
            )
        }
    }
}