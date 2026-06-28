package com.example.pizzeria_elguero.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class PizzaOrder(
    val type: String,
    val size: String,
    val amount: String
)

class OrderViewModel : ViewModel() {

    var orders = mutableStateListOf<PizzaOrder>()
        private set

    fun addOrder(type: String, size: String, amount: String) {
        if (type.isNotBlank() && size.isNotBlank() && amount.isNotBlank()) {
            orders.add(
                PizzaOrder(
                    type = type,
                    size = size,
                    amount = amount
                )
            )
        }
    }

    fun clearOrders() {
        orders.clear()
    }
}