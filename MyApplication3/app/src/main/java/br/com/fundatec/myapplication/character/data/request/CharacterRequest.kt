package br.com.fundatec.myapplication.character.data.request


data class CharacterRequest(
    val name: String,
    val description: String,
    val image: String,
    val universeType: String,
    val characterType: String,
    val age: Int,
    val birthday: String?
)