package com.bytemax.smartsettings

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bytemax.smartsettings.presentation.NavigationRoutes
import com.bytemax.smartsettings.presentation.components.screens.CreateProfileScreen
import com.bytemax.smartsettings.presentation.components.screens.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoutes.HomeScreen.route) {
        composable(route = NavigationRoutes.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = NavigationRoutes.CreateProfileScreen.route) {
            CreateProfileScreen(navController = navController)
        }
    }
}