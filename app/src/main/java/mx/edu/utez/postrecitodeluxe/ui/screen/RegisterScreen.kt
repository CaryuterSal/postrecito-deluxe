package mx.edu.utez.postrecitodeluxe.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import mx.edu.utez.postrecitodeluxe.R
import mx.edu.utez.postrecitodeluxe.ui.components.buttons.PrimaryButton
import mx.edu.utez.postrecitodeluxe.ui.components.text.Link
import mx.edu.utez.postrecitodeluxe.ui.components.images.CircularImage
import mx.edu.utez.postrecitodeluxe.ui.components.inputs.PasswordField2
import mx.edu.utez.postrecitodeluxe.ui.components.inputs.UserInputField2
import mx.edu.utez.postrecitodeluxe.viewmodel.RegisterViewModel


@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterViewModel = RegisterViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        CircularImage(R.drawable.pastel)

        UserInputField2(
            viewModel = viewModel,
            label = "Usuario"
        )
        UserInputField2(
            viewModel = viewModel,
            label = "Correo"
        )
        PasswordField2(
            viewModel = viewModel,
            label = "Contraseña"
        )

        PasswordField2(
            viewModel = viewModel,
            label = "Confirmar contraseña"
        )

        Spacer(modifier = Modifier.height(5.dp))

        PrimaryButton(text = "Registrarse") {
            viewModel.register {
                navController.navigate("homeScreen") {
                    popUpTo("register") { inclusive = true }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(modifier = Modifier.weight(1f), color = Color.Gray)
            Text(" Iniciar sesión con ", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
            Divider(modifier = Modifier.weight(1f), color = Color.Gray)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(painterResource(R.drawable.logotipos), contentDescription = "Twitter", modifier = Modifier.size(30.dp))
            Icon(painterResource(R.drawable.letra_g), contentDescription = "Google", modifier = Modifier.size(30.dp))
            Icon(painterResource(R.drawable.facebook), contentDescription = "Facebook", modifier = Modifier.size(30.dp))
        }

        Spacer(modifier = Modifier.height(10.dp))
        Link("Ya tengo cuenta") {
            navController.popBackStack()
        }
    }
}