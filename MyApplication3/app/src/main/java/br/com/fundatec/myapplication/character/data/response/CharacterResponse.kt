package br.com.fundatec.myapplication.character.data.response


data class CharacterResponse(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val universeType: String,
    val characterType: String,
    val age: Float,
    val birthday: String?
)
