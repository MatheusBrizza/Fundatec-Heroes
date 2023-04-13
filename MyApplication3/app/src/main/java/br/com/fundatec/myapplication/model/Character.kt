package br.com.fundatec.myapplication.model

import java.time.LocalDate


data class Character(
    val name: String,
    val url: String,
    val description: String,
    val marvelDc: universeType,
    val heroiVilao: characterType,
    val age: Int,
    val dateOfBirth: LocalDate,
) {
    enum class universeType { Marvel, DC }
    enum class characterType { hero, vilain}
}
