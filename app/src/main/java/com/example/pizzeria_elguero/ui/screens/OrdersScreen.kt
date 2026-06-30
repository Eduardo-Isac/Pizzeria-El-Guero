package com.example.pizzeria_elguero.ui.screens
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

// LazyColumn sirve para mostrar listas
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed

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

// Recursos y modelos del proyecto
import com.example.pizzeria_elguero.R
import com.example.pizzeria_elguero.model.Order
import com.example.pizzeria_elguero.viewmodel.OrderViewModel
@Composable
fun OrdersScreen(
    navController: NavController,
    orderViewModel: OrderViewModel
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondos),
                contentScale = ContentScale.Crop)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Pedidos",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(30.dp))
            if (orderViewModel.orders.isEmpty()) {
                Text(
                    text = "No hay pedidos guardados",
                    color = Color.White)
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    itemsIndexed(orderViewModel.orders) { index, order ->
                        OrderCard(
                            number = index + 1,
                            order = order
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    context.startActivity(Intent(
                        context, LoginActivity::class.java))
                    (context as Activity).finish()
                },
                modifier = Modifier.width(220.dp)
            ) {
                Text(text = "salir")
            }
        }
    }
}

@Composable
fun OrderCard(
    number: Int,
    order: Order
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Pedido #$number",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Tipo: ${order.type}")
            Text(text = "Tamaño: ${order.size}")
            Text(text = "Cantidad: ${order.amount}")
        }
    }
}