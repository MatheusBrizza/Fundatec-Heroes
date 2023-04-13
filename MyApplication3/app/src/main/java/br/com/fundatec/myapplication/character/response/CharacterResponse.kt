package br.com.fundatec.myapplication.character.response

import android.widget.Spinner

data class CharacterResponse(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val universeType: Spinner,
    val characterType: Spinner,
    val age: Int,
    val date: String
)
