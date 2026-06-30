package com.example.pizzeria_elguero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.pizzeria_elguero.navigation.NavGraph
import com.example.pizzeria_elguero.ui.theme.Pizzeria_ELGUEROTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pizzeria_ELGUEROTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}