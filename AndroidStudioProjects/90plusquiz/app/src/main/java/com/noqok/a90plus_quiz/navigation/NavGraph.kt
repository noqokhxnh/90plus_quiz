package com.noqok.a90plus_quiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.noqok.a90plus_quiz.ui.screens.GameMode1Screen
import com.noqok.a90plus_quiz.ui.screens.GameMode2Screen
import com.noqok.a90plus_quiz.ui.screens.GameMode3Screen
import com.noqok.a90plus_quiz.ui.screens.MainScreen
import com.noqok.a90plus_quiz.ui.screens.ProfileScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.GameMode1.route) {
            GameMode1Screen()
        }
        composable(route = Screen.GameMode2.route) {
            GameMode2Screen()
        }
        composable(route = Screen.GameMode3.route) {
            GameMode3Screen()
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
    }
}
