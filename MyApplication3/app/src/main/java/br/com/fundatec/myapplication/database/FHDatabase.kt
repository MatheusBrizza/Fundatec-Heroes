package br.com.fundatec.myapplication.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fundatec.myapplication.App
import br.com.fundatec.myapplication.character.data.local.CharacterDao
import br.com.fundatec.myapplication.character.data.local.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class FHDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object {
        fun getInstance(): FHDatabase {
            return Room.databaseBuilder(
                App.context,
                FHDatabase::class.java,
                "fh.database"
            ).build()
        }
    }
}