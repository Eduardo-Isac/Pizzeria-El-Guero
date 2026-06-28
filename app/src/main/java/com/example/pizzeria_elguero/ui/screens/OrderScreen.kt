package com.example.pizzeria_elguero.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavController
import com.example.pizzeria_elguero.R
import com.example.pizzeria_elguero.viewmodel.OrderViewModel

@Composable
fun OrderScreen(
    navController: NavController,
    orderViewModel: OrderViewModel
) {

    var type by remember { mutableStateOf("") }
    var size by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondos),
                contentScale = ContentScale.Crop
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Pedido",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(45.dp))

            OutlinedTextField(
                value = type,
                onValueChange = { type = it },
                placeholder = { Text("Tipo") },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )

            Spacer(modifier = Modifier.height(35.dp))

            OutlinedTextField(
                value = size,
                onValueChange = { size = it },
                placeholder = { Text("Tamaño") },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )

            Spacer(modifier = Modifier.height(35.dp))

            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                placeholder = { Text("Cantidad") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFDFBF2),
                    unfocusedContainerColor = Color(0xFFFDFBF2),
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )

            Spacer(modifier = Modifier.height(35.dp))

            Text(
                text = message,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                modifier = Modifier.width(220.dp),
                onClick = {
                    if (type.isNotBlank() && size.isNotBlank() && amount.isNotBlank()) {
                        orderViewModel.addOrder(type, size, amount)

                        type = ""
                        size = ""
                        amount = ""

                        message = "Pedido guardado"
                    } else {
                        message = "Llena todos los campos"
                    }
                }
            ) {
                Text(text = "Guardar")
            }

            Spacer(modifier = Modifier.height(20.dp))

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