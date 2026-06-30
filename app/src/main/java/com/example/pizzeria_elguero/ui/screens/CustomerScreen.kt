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
fun CustomerScreen(navController: NavController) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondos),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Cliente",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                modifier = Modifier.width(220.dp),
                onClick = {
                    navController.navigate(Routes.PIZZA_MENU)
                }
            ) {
                Text("Ver menu")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.width(220.dp),
                onClick = {
                    navController.navigate(Routes.ORDER)
                }
            ) {
                Text("Hacer pedido")
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                modifier = Modifier.width(220.dp),
                onClick = {
                    context.startActivity(
                        Intent(context, LoginActivity::class.java)
                    )

                    (context as Activity).finish()
                }
            ) {
                Text("Salir")
            }
        }
    }
}