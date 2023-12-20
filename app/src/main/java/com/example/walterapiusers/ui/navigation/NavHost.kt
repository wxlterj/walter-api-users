package com.example.walterapiusers.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.walterapiusers.ui.form.UserForm
import com.example.walterapiusers.ui.getuser.GetUserScreen
import com.example.walterapiusers.ui.home.HomeScreen
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.walterapiusers.ui.form.UserFormViewModel

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.Home.route,
    ) {
        composable(NavigationRoute.Home.route) {
            HomeScreen(onRegistrerClicked = { navController.navigate(NavigationRoute.Register.route) })
        }
        composable(NavigationRoute.Register.route) {
            UserForm(onRegisterClicked = {})
        }
        composable(NavigationRoute.GetUser.route) {
            GetUserScreen(
                firsName = "Walter",
                lastName = "Fernandez",
                email = "oelo",
                phoneNumber = "314545",
                onEditClicked = { /*TODO*/ },
                onDeleteClicked = {}
            )
        }
    }
}