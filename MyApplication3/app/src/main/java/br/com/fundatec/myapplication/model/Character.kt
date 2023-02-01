package br.com.fundatec.myapplication.model

import java.time.LocalDate


data class Character(
    val name: String,
    val url: String,
    val description: String,
    val marvelDc: Enum,
    val age: Int,
    val dateOfBirth: LocalDate,
) {
    enum class Enum { Marvel, DC }
}
