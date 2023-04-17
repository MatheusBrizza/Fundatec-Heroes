package br.com.fundatec.myapplication.profile.data.remote

data class UserRequest(
    val name: String,
    val email: String,
    val password: String
)