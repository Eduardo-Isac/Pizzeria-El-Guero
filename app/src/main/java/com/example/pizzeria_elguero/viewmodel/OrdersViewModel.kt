package com.example.pizzeria_elguero.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.pizzeria_elguero.model.Order

class OrderViewModel : ViewModel() {

    companion object {

        private var nextId = 1

        private val savedOrders = mutableStateListOf<Order>()

        fun clearAllOrders() {
            savedOrders.clear()
            nextId = 1
        }
    }

    var orders = savedOrders
        private set

    fun addOrder(type: String, size: String, amount: String): Boolean {

        if (type.isBlank() || size.isBlank() || amount.isBlank()) {
            return false
        }

        val amountInt = amount.toIntOrNull()

        if (amountInt == null || amountInt <= 0) {
            return false
        }

        orders.add(
            Order(
                id = nextId++,
                type = type,
                size = size,
                amount = amountInt
            )
        )

        return true
    }
}