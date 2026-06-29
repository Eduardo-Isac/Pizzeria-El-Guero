package com.example.pizzeria_elguero.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pizzeria_elguero.model.User
class UsersViewModel : ViewModel() {

    // Lista local de usuarios permitidos
    private val users = listOf(
        User(username = "marilu", password = "qwerty"),
        User(username = "isac", password = "1234"),
        User(username = "admin", password = "qwerty123")
    )

    // Funcion que valida si el usuario y la contrasena son correctos
    fun validateLogin(username: String, password: String): Boolean {

        // Busca si existe un usuario con el mismo nombre y contrasena
        return users.any { user ->
            user.username == username && user.password == password
        }
    }
}