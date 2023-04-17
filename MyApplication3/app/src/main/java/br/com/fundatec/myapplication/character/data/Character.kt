package br.com.fundatec.myapplication.character.data



data class Character(
    val id: Int,
    val apiId: Int,
    val name: String,
    val url: String,
    val description: String,
    val marvelDc: MarvelDC,
    val heroiVilao: HeroVillain,
    val age: String,
    val dateOfBirth: String?,
)
    enum class MarvelDC { MARVEL, DC }
    enum class HeroVillain { HERO, VILLAIN}

