package br.com.fundatec.myapplication.character.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "characterTable")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val apiId: Int,
    val name: String,
    val image: String,
    val description: String,
    val universeType: marvelDC,
    val characterType: heroVillain,
    val age: Int,
    val birthday: String?
) {
    enum class marvelDC { MARVEL, DC }
    enum class heroVillain { HERO, VILLAIN }
}