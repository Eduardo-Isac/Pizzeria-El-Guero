package com.example.pizzeria_elguero

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pizzeria_elguero.ui.screens.LoginScreen
import com.example.pizzeria_elguero.ui.theme.Pizzeria_ELGUEROTheme
import com.example.pizzeria_elguero.viewmodel.OrderViewModel

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Pizzeria_ELGUEROTheme {
                LoginScreen(
                    onLoginSuccess = {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    },
                    onExit = {
                        OrderViewModel.clearAllOrders()
                        finishAffinity()
                    }
                )
            }
        }
    }
}