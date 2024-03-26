package com.bytemax.smartsettings

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home_screen")
    data object CreateProfileScreen : Screen("create_profile_screen")
}