package com.example.walterapiusers.ui.navigation

sealed class NavigationRoute(val route: String) {
    object Home: NavigationRoute(route = "home")
    object Register: NavigationRoute(route = "register")
    object GetUser: NavigationRoute(route = "get_user")
}