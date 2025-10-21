package mx.edu.utez.postrecitodeluxe.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.postrecitodeluxe.ui.screen.CreateCakeScreen
import mx.edu.utez.postrecitodeluxe.ui.screen.EditCakeScreen
import mx.edu.utez.postrecitodeluxe.ui.screen.ForgotPasswordScreen
import mx.edu.utez.postrecitodeluxe.ui.screen.HomeScreen
import mx.edu.utez.postrecitodeluxe.ui.screen.LoginScreen
import mx.edu.utez.postrecitodeluxe.ui.screen.RegisterScreen
import mx.edu.utez.postrecitodeluxe.viewmodel.CakePreviewViewModel
import mx.edu.utez.postrecitodeluxe.viewmodel.HomeViewModel
import mx.edu.utez.postrecitodeluxe.viewmodel.LoginViewModel


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel()
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("register") { RegisterScreen(navController) }
        composable("home") {
            val viewModel: HomeViewModel = viewModel()
            HomeScreen(viewModel = viewModel, navController = navController)
        }

        composable("editCake"){
            val viewModel: CakePreviewViewModel = viewModel()
            EditCakeScreen(viewModel = viewModel, navController = navController)
        }

        composable("createCake"){
            val viewModel: CakePreviewViewModel = viewModel()
            CreateCakeScreen(viewModel = viewModel, navController = navController)
        }
        composable("forgot_password") {
            ForgotPasswordScreen()
        }

    }
}