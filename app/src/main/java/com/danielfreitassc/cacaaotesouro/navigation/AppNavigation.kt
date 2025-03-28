package com.danielfreitassc.cacaaotesouro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.danielfreitassc.cacaaotesouro.ui.screens.HomeScreen
import com.danielfreitassc.cacaaotesouro.ui.screens.QuestionScreen
import com.danielfreitassc.cacaaotesouro.ui.screens.TreasureScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("question/{attempt}") { backStackEntry ->
            val attempt = backStackEntry.arguments?.getString("attempt")?.toIntOrNull() ?: 1
            QuestionScreen(navController, attempt)
        }
        composable("treasure") {
            TreasureScreen(navController)
        }
    }
}
