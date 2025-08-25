package com.noqok.a90plus_quiz.navigation

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object GameMode1 : Screen("game_mode_1")
    object GameMode2 : Screen("game_mode_2")
    object GameMode3 : Screen("game_mode_3")
    object Profile : Screen("profile_screen")
}
