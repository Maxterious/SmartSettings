package com.bytemax.smartsettings

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bytemax.smartsettings.ui.Screen
import com.bytemax.smartsettings.ui.components.screens.CreateProfileScreen
import com.bytemax.smartsettings.ui.components.screens.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.CreateProfileScreen.route) {
            CreateProfileScreen(navController = navController)
        }
    }
}