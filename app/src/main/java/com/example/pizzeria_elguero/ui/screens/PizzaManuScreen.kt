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

// Componentes visuales de Material 3
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

// Indica que esta funcion es una pantalla de Compose
import androidx.compose.runtime.Composable

// Imports visuales
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// Controlador de navegacion
import androidx.navigation.NavController
import com.example.pizzeria_elguero.LoginActivity

// Recursos del proyecto
import com.example.pizzeria_elguero.R
@Composable
fun PizzaMenuScreen(navController: NavController) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondos),
                contentScale = ContentScale.Crop)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(
                text = "Menu de pizzas",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(30.dp))
            Card(
                modifier = Modifier.width(300.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.85f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text("Gato Naranja ... C $120 - G $150")
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Ingredientes: Jamon y piña")
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Calico ... C $140 - G $170")
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Ingredientes: Picadillo, chorizo, jamon y pollo")
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Persa ... C $130 - G $160")
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Ingredientes: Cuatro quesos")
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Siames ... C $120 - G $150")
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Ingredientes: Queso y pepperoni")
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Mein Coon ... C $150 - G $180")
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Ingredientes: Mar y tierra")
                    Spacer(modifier = Modifier.height(16.dp)) } }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                modifier = Modifier.width(220.dp),
                onClick = {
                    context.startActivity(Intent(
                        context, LoginActivity::class.java))
                    (context as Activity).finish()
                     }) {
                Text("salir") }
        }
    }
}