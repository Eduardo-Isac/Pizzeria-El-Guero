package com.example.pizzeria_elguero.ui.screens

// Imports para organizar la pantalla
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

// Sirve para mostrar teclado numerico en el campo cantidad
import androidx.compose.foundation.text.KeyboardOptions

// Componentes visuales de Material 3
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text

// Estados de Compose
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// Imports visuales
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Controlador de navegacion
import androidx.navigation.NavController

// Recursos y ViewModel del proyecto
import com.example.pizzeria_elguero.R
import com.example.pizzeria_elguero.viewmodel.OrderViewModel

@Composable
fun OrderScreen(
    navController: NavController,
    orderViewModel: OrderViewModel
) {
    // Guarda el tipo de pizza escrito por el usuario
    var type by remember { mutableStateOf("") }

    // Guarda el tamano escrito por el usuario
    var size by remember { mutableStateOf("") }

    // Guarda la cantidad escrita por el usuario
    var amount by remember { mutableStateOf("") }

    // Guarda el mensaje que se muestra al usuario
    var message by remember { mutableStateOf("") }

    // Colores para los campos de texto
    val coloresCampos = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.Black,
        unfocusedTextColor = Color.Black,
        cursorColor = Color.Black,
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        focusedBorderColor = Color.Transparent,
        unfocusedBorderColor = Color.Transparent
    )

    // Contenedor principal con imagen de fondo
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondos),
                contentScale = ContentScale.Crop
            ),
        contentAlignment = Alignment.Center
    ) {

        // Column acomoda los elementos verticalmente
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Titulo de la pantalla
            Text(
                text = "Pedido",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(45.dp))

            // Campo para escribir el tipo de pizza
            OutlinedTextField(
                value = type,
                onValueChange = { type = it },
                placeholder = { Text("Tipo", color = Color.Black) },
                singleLine = true,
                colors = coloresCampos,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )

            Spacer(modifier = Modifier.height(35.dp))

            // Campo para escribir el tamano de la pizza
            OutlinedTextField(
                value = size,
                onValueChange = { size = it },
                placeholder = { Text("Tamaño", color = Color.Black) },
                singleLine = true,
                colors = coloresCampos,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )

            Spacer(modifier = Modifier.height(35.dp))

            // Campo para escribir la cantidad de pizzas
            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                placeholder = { Text("Cantidad", color = Color.Black) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = coloresCampos,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )

            Spacer(modifier = Modifier.height(35.dp))

            // Mensaje de confirmacion o error
            Text(
                text = message,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Boton para guardar el pedido
            Button(
                modifier = Modifier.width(220.dp),
                onClick = {

                    // Manda los datos al ViewModel
                    val guardado = orderViewModel.addOrder(
                        type = type,
                        size = size,
                        amount = amount
                    )

                    // Si se guardo correctamente limpia los campos
                    if (guardado) {
                        type = ""
                        size = ""
                        amount = ""
                        message = "Pedido guardado"
                    } else {
                        message = "Llena todos los campos correctamente"
                    }
                }
            ) {
                Text(text = "Guardar")
            }

            Spacer(modifier = Modifier.height(20.dp))

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