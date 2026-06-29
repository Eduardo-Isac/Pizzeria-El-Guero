package com.example.pizzeria_elguero.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pizzeria_elguero.ui.screens.CustomerScreen
import com.example.pizzeria_elguero.ui.screens.MenuScreen
import com.example.pizzeria_elguero.ui.screens.OrderScreen
import com.example.pizzeria_elguero.ui.screens.OrdersScreen
import com.example.pizzeria_elguero.ui.screens.PizzaMenuScreen
import com.example.pizzeria_elguero.ui.screens.UsScreen
import com.example.pizzeria_elguero.viewmodel.OrderViewModel

// NavGraph es el mapa de navegacion de la aplicacion
// Aqui se conecta cada ruta con su pantalla correspondiente
@Composable
fun NavGraph(navController: NavHostController) {

    // Se crea el ViewModel de pedidos dentro del NavGraph
    // Esto permite compartir los pedidos entre OrderScreen y OrdersScreen
    val orderViewModel: OrderViewModel = viewModel()

    // NavHost contiene las rutas internas de MainActivity
    // startDestination indica la primera pantalla que se muestra
    NavHost(
        navController = navController,
        startDestination = Routes.MENU
    ) {
        composable(Routes.MENU) {
            MenuScreen(navController = navController)
        }
        composable(Routes.CUSTOMER) {
            CustomerScreen(navController = navController)
        }
        composable(Routes.PIZZA_MENU) {
            PizzaMenuScreen(navController = navController)
        }
        composable(Routes.ORDER) {
            OrderScreen(
                navController = navController,
                orderViewModel = orderViewModel
            )
        }
        composable(Routes.ORDERS) {
            OrdersScreen(
                navController = navController,
                orderViewModel = orderViewModel
            )
        }
        composable(Routes.US) {
            UsScreen(navController = navController)
        }
    }
}