package mx.edu.utez.postrecitodeluxe.ui.data.model

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.postrecitodeluxe.ui.data.screens.LoginScreen
import mx.edu.utez.postrecitodeluxe.ui.data.screens.RegisterScreen
import mx.edu.utez.postrecitodeluxe.ui.data.viewmodel.LoginViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel() // instancia del ViewModel
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("register") { RegisterScreen(navController) }
    }
}