package br.com.fundatec.myapplication.character.data

import java.time.LocalDate


data class Character(
    val name: String,
    val url: String,
    val description: String,
    val marvelDc: universeType,
    val heroiVilao: characterType,
    val age: String,
    val dateOfBirth: String,
) {
    enum class universeType { Marvel, DC }
    enum class characterType { heroi, vilao}
}
