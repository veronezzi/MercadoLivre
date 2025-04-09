package com.example.mercadolivre.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mercadolivre.presentation.details.compose.ProductDetailScreen
import com.example.mercadolivre.presentation.search.compose.SearchAndResultsScreen

@Composable
fun MercadoLibreNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Search.withArgs(false)
    ) {
        composable(
            route = Screen.Search.routeWithArgs,
            arguments = listOf(
                navArgument("showResults") {
                    type = NavType.StringType
                    defaultValue = "false"
                }
            )
        ) { backStackEntry ->
            SearchAndResultsScreen(
                navController = navController,
            )
        }

        composable(
            route = Screen.ProductDetail.routeWithArgs,
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailScreen(
                productId = productId,
                navController = navController
            )
        }
    }
}

sealed class Screen(val route: String) {

    object Search : Screen("search") {
        const val routeWithArgs = "search/{showResults}"
        fun withArgs(showResults: Boolean) = "search/${showResults}"
    }

    object ProductDetail : Screen("product_detail") {
        const val routeWithArgs = "product_detail/{productId}"
        fun withArgs(productId: String) = "product_detail/$productId"
    }
}
