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
import com.example.pizzeria_elguero.viewmodel.OrderViewModel

@Composable
fun NavGraph(navController: NavHostController) {

    val orderViewModel: OrderViewModel = viewModel()

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
    }
}