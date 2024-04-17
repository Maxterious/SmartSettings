package com.bytemax.smartsettings.presentation

sealed class NavigationRoutes(val route: String) {
    data object HomeScreen : NavigationRoutes("home_screen")
    data object CreateProfileScreen : NavigationRoutes("create_profile_screen")
}