package com.example.pizzeria_elguero.ui.screens

// Image permite mostrar una imagen
import androidx.compose.foundation.Image

// Imports para organizar la pantalla
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

// Componentes visuales de Material 3
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text

// Indica que esta funcion es una pantalla de Compose
import androidx.compose.runtime.Composable

// Imports visuales
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Controlador de navegacion
import androidx.navigation.NavController

// Recursos del proyecto
import com.example.pizzeria_elguero.R

@Composable
fun UsScreen(navController: NavController) {

    // Contenedor principal con fondo
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondos),
                contentScale = ContentScale.Crop
            ),
        contentAlignment = Alignment.Center
    ) {

        // Column acomoda todo verticalmente
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Titulo de la pantalla
            Text(
                text = "Nosotros",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Imagen representativa de la pizzeria
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Logo de la pizzeria",
                modifier = Modifier.size(130.dp)
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Tarjeta con informacion de la pizzeria
            Card(
                modifier = Modifier.width(310.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.90f)
                )
            ) {

                // Contenido de la tarjeta
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Nombre de la pizzeria
                    Text(
                        text = "Pizzería El Güero",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    // Descripcion general de la pizzeria
                    Text(
                        text = "Somos una pizzería inspirada en los gatos, creada para ofrecer un lugar divertido para disfrutar con tu mascota",
                        fontSize = 16.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Explicacion del concepto de la pizzeria
                    Text(
                        text = "Nuestro concepto mezcla el amor por la pizza con un ambiente felino, usando nombres inspirados en gatos",
                        fontSize = 16.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(35.dp))

                    // Boton para regresar a la pantalla anterior
                    Button(
                        modifier = Modifier.width(220.dp),
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Text(text = "Volver")
                    }
                }
            }
        }
    }
}