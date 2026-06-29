package com.example.pizzeria_elguero.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pizzeria_elguero.LoginActivity
import com.example.pizzeria_elguero.R
import com.example.pizzeria_elguero.navigation.Routes

@Composable
fun MenuScreen(navController: NavController) {

    // Obtiene el contexto actual para abrir LoginActivity
    val context = LocalContext.current

    // Contenedor principal con fondo
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondos),
                contentScale = ContentScale.Crop
            )
    ) {

        // Column acomoda los botones verticalmente
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Titulo del menu principal
            Text(
                text = "Menu principal",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Boton para ir a la pantalla Cliente
            Button(
                modifier = Modifier.width(220.dp),
                onClick = {
                    navController.navigate(Routes.CUSTOMER)
                }
            ) {
                Text("Cliente")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Boton para ir a la pantalla de pedidos guardados
            Button(
                modifier = Modifier.width(220.dp),
                onClick = {
                    navController.navigate(Routes.ORDERS)
                }
            ) {
                Text("Ver pedidos")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Boton para ir a la pantalla Nosotros
            Button(
                modifier = Modifier.width(220.dp),
                onClick = {
                    navController.navigate(Routes.US)
                }
            ) {
                Text("Nosotros")
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Boton para regresar al login
            Button(
                onClick = {
                    context.startActivity(Intent(context, LoginActivity::class.java))
                    (context as Activity).finish()
                }
            ) {
                Text("Salir")
            }
        }
    }
}