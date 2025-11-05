package mx.edu.utez.postrecitodeluxe.ui

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import mx.edu.utez.postrecitodeluxe.persistence.AppDatabase
import mx.edu.utez.postrecitodeluxe.ui.screen.CodePasswordScreen
import mx.edu.utez.postrecitodeluxe.ui.screen.CreateCakeScreen
import mx.edu.utez.postrecitodeluxe.ui.screen.EditCakeScreen

import mx.edu.utez.postrecitodeluxe.ui.screen.HomeScreen
import mx.edu.utez.postrecitodeluxe.ui.screen.LoginScreen
import mx.edu.utez.postrecitodeluxe.ui.screen.RegisterScreen
import mx.edu.utez.postrecitodeluxe.viewmodel.CakeViewModel
import mx.edu.utez.postrecitodeluxe.viewmodel.LoginViewModel
import mx.edu.utez.postrecitodeluxe.ui.screen.ForgotPasswordScreen
import mx.edu.utez.postrecitodeluxe.ui.screen.NewPassword

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val cakeViewModel: CakeViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel()
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("register") { RegisterScreen(navController) }
        composable("home") {
            HomeScreen(viewModel = cakeViewModel, navController = navController)
        }

        composable("editCake"){
            EditCakeScreen(viewModel = cakeViewModel, navController = navController)
        }

        composable("createCake"){
            CreateCakeScreen(viewModel = cakeViewModel, navController = navController)
        }

        composable("forgotPassword"){
            ForgotPasswordScreen(viewModel = cakeViewModel, navController = navController)
        }

        composable("CodePassword"){
            CodePasswordScreen(viewModel = cakeViewModel, navController = navController)
        }

        composable("NewPassword"){
            NewPassword(viewModel = cakeViewModel, navController = navController)
        }




    }
}