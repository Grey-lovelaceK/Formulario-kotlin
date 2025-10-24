package com.example.formandlistapp

data class User(
    val nombre: String,
    val correo: String,
    val telefono: String,
    val edad: String,
    val direccion: String
)

object DataRepository {
    val users = mutableListOf<User>()

    fun addUser(user: User) {
        users.add(user)
    }
}
