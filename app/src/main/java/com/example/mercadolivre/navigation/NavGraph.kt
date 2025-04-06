package com.example.mercadolivre.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mercadolivre.presentation.details.compose.ProductDetailScreen
import com.example.mercadolivre.presentation.results.compose.ResultsScreen
import com.example.mercadolivre.presentation.search.compose.SearchScreen

@Composable
fun MercadoLibreNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Search.route
    ) {
        composable(route = Screen.Search.route) {
            SearchScreen(navController)
        }
        composable(
            route = Screen.Results.routeWithArgs,
            arguments = listOf(navArgument("query") { type = NavType.StringType })
        ) { backStackEntry ->
            ResultsScreen(
                navController = navController,
                query = backStackEntry.arguments?.getString("query") ?: ""
            )
        }
        composable(
            route = Screen.ProductDetail.routeWithArgs,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            ProductDetailScreen(
                productId = backStackEntry.arguments?.getString("productId") ?: "",
                navController = navController
            )
        }
    }
}

sealed class Screen(val route: String) {
    object Search : Screen("search")
    object Results : Screen("results") {
        const val routeWithArgs = "results/{query}"
    }
    object ProductDetail : Screen("product_detail") {
        const val routeWithArgs = "product_detail/{productId}"
    }

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}