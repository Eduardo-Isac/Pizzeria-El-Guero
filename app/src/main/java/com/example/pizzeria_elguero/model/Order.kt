package com.example.pizzeria_elguero.model

// Modelo de datos para representar un pedido
data class Order(

    // Identificador unico del pedido
    val id: Int,

    // Tipo de pizza
    val type: String = "",

    // Tamano de la pizza
    val size: String = "",

    // Cantidad de pizzas
    val amount: Int = 1
)