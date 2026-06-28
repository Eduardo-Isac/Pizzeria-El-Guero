package com.example.pizzeria_elguero.model


data class Order(
    val id: Int,
    val type: String = "",
    val size: String= "",
    val amount: Int = 1,
)
