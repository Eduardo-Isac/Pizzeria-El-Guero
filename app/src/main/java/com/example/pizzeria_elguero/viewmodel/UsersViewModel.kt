package com.example.pizzeria_elguero.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pizzeria_elguero.model.User

class UsersViewModel : ViewModel () {
    private val users = listOf(
        User(username = "marilu", password = "qwerty"),
        User (username = "isac", password = "1234"),
        User (username = "admin", password = "qwerty123")
    )
    fun validateLogin (username : String, password: String): Boolean{
        return users.any { user ->
            user.username == username && user.password == password
        }
    }
}