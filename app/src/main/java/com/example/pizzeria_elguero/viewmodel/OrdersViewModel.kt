package com.example.pizzeria_elguero.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.pizzeria_elguero.model.Order


class OrderViewModel : ViewModel() {

    // Variable para generar un id unico para cada pedido
    private var nextId = 1

    // Lista donde se guardan los pedidos
    var orders = mutableStateListOf<Order>()
        private set

    // Funcion para agregar un pedido nuevo
    fun addOrder(type: String, size: String, amount: String): Boolean {

        // Si algun campo esta vacio no se guarda el pedido
        if (type.isBlank() || size.isBlank() || amount.isBlank()) {
            return false
        }

        // Convierte la cantidad de texto a numero entero
        val amountInt = amount.toIntOrNull()

        // Si la cantidad no es numero o es menor o igual a 0 no se guarda
        if (amountInt == null || amountInt <= 0) {
            return false
        }

        // Agrega el pedido a la lista
        orders.add(
            Order(
                id = nextId++,
                type = type,
                size = size,
                amount = amountInt
            )
        )

        // Regresa true para indicar que el pedido se guardo correctamente
        return true
    }
}