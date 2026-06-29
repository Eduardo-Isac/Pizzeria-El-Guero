package com.example.pizzeria_elguero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.pizzeria_elguero.navigation.NavGraph
import com.example.pizzeria_elguero.ui.theme.Pizzeria_ELGUEROTheme

// MainActivity es la segunda Activity de la app
// Aqui se muestran el menu principal y las demas pantallas internas
class MainActivity : ComponentActivity() {
    // onCreate se ejecuta cuando se abre esta Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent indica que la interfaz se hara con Jetpack Compose
        setContent {
            // Aplica el tema visual de la aplicacion
            Pizzeria_ELGUEROTheme {
                // Crea el controlador para moverse entre pantallas
                val navController = rememberNavController()
                // Llama al mapa de navegacion de la app
                NavGraph(navController = navController)
            }
        }
    }
}