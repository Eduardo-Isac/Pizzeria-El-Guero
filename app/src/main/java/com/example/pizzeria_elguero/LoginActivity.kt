package com.example.pizzeria_elguero

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pizzeria_elguero.ui.screens.LoginScreen
import com.example.pizzeria_elguero.ui.theme.Pizzeria_ELGUEROTheme
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pizzeria_ELGUEROTheme {
                LoginScreen(
                    // Esta accion se ejecuta cuando el usuario inicia sesion correctamente
                    onLoginSuccess = {
                        // Abre MainActivity para mostrar el menu principal
                        startActivity(Intent(this, MainActivity::class.java))
                        // Cierra LoginActivity para que no quede abierta atras
                        finish()
                    },
                    // Esta accion se ejecuta cuando el usuario presiona salir
                    onExit = {
                        // Cierra completamente la aplicacion
                        finishAffinity()
                    }
                )
            }
        }
    }
}