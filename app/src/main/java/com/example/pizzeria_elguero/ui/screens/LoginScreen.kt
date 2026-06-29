package com.example.pizzeria_elguero.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pizzeria_elguero.R
import com.example.pizzeria_elguero.viewmodel.UsersViewModel

@Composable
fun LoginScreen(
    usersViewModel: UsersViewModel = viewModel(),
    onLoginSuccess: () -> Unit,
    onExit: () -> Unit
) {
    // Guarda el usuario escrito en el campo de texto
    var usuario by remember { mutableStateOf("") }

    // Guarda la contrasena escrita en el campo de texto
    var password by remember { mutableStateOf("") }

    // Guarda el mensaje de error cuando el login falla
    var error by remember { mutableStateOf("") }

    // Contenedor principal con imagen de fondo
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondologin),
                contentScale = ContentScale.Crop
            )
    ) {

        // Column acomoda los elementos del login de arriba hacia abajo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Titulo de la aplicacion
            Text(
                text = "Pizzeria El Guero",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Logo de la pizzeria
            Image(
                painter = painterResource(id = R.drawable.logopizza),
                contentDescription = "Logo de la pizzeria",
                modifier = Modifier.size(190.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Texto de inicio de sesion
            Text(
                text = "Iniciar sesion",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Campo para escribir el usuario
            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuario") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Campo para escribir la contrasena
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contrasena") },
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Boton para validar el inicio de sesion
            Button(
                onClick = {

                    // Se valida el usuario usando UsersViewModel
                    val loginCorrecto = usersViewModel.validateLogin(
                        username = usuario,
                        password = password
                    )

                    // Si el login es correcto se ejecuta onLoginSuccess
                    if (loginCorrecto) {
                        onLoginSuccess()
                    } else {
                        error = "Usuario o contrasena incorrectos"
                    }
                }
            ) {
                Text("Entrar", color = Color.White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Boton para cerrar la aplicacion desde el login
            Button(
                onClick = {
                    onExit()
                }
            ) {
                Text("Salir", color = Color.White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Muestra el mensaje de error si existe
            if (error.isNotBlank()) {
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}