package mx.edu.utez.postrecitodeluxe.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import mx.edu.utez.postrecitodeluxe.R
import mx.edu.utez.postrecitodeluxe.ui.components.buttons.PrimaryButton
import mx.edu.utez.postrecitodeluxe.ui.components.images.CircularImage
import mx.edu.utez.postrecitodeluxe.ui.components.text.Link
import mx.edu.utez.postrecitodeluxe.viewmodel.LoginViewModel
import mx.edu.utez.postrecitodeluxe.ui.components.inputs.PasswordField
import mx.edu.utez.postrecitodeluxe.ui.components.inputs.UserInputField

@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        CircularImage(R.drawable.pastel)
        UserInputField(
            value = viewModel.email.value,
            onValueChange = {viewModel.email.value = (it)},
            label = "Correo"
        )
        PasswordField(
            value = viewModel.password.value,
            onValueChange = {viewModel.password.value = (it)},
            label = "Contraseña"
        )

        if (viewModel.loginError.value.isNotEmpty()) {
            Text(
                text = viewModel.loginError.value,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        PrimaryButton(text = "Iniciar sesión") {
            viewModel.login {
                navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }
        Text(
            text = "No tengo cuenta",
            style = MaterialTheme.typography.bodyMedium
        )

        Button(
            onClick = { navController.navigate("register") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFAF88AF))
        ) {
            Text("Registrarse", color = Color.White)
        }
        Text(
            text = "Iniciar sesión con",
            modifier = Modifier.padding(top = 10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(painterResource(R.drawable.logotipos), contentDescription = "Twitter")
            Icon(painterResource(R.drawable.letra_g), contentDescription = "Google")
            Icon(painterResource(R.drawable.facebook), contentDescription = "Facebook")
        }

        Link("¿Olvidaste tu contraseña?") {
            navController.navigate("forgotPassword")
        }
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    PostrecitoDeluxeTheme {
        val navController = rememberNavController()
        val viewModel = LoginViewModel()

        LoginScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}