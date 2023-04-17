package br.com.fundatec.myapplication.character.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterDao {
    @Insert
    fun insertCharacter(userEntity: CharacterEntity)

    @Query("SELECT * from  characterTable")
    fun getCharacters(): List<CharacterEntity>

    @Query("SELECT * from characterTable WHERE characterType = :characterType")
    fun findByHV(characterType: String): List<CharacterEntity>
}