package com.base.starter.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.base.starter.ui.screen.FirstScreen.FirstScreen
import com.base.starter.ui.screen.SecondScreen.SecondScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.First) {
        composable<Screen.First> {
            FirstScreen(onNavigateToSecond = {
                navController.navigate(Screen.Second)
            })
        }
        composable<Screen.Second> {
            SecondScreen(onBack = {
                navController.popBackStack()
            })
        }
        // Add other screens here
    }
}