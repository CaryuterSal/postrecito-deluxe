package mx.edu.utez.postrecitodeluxe.ui.screen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import mx.edu.utez.postrecitodeluxe.viewmodel.CakeViewModel


@Composable
fun ForgotPasswordScreen(
    navController: NavController, viewModel: CakeViewModel = viewModel()
) {


    val regresoLoginClick: () -> Unit = {
        navController.navigate("login")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "¿Olvidaste tu Contraseña?",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp),
                    textAlign = TextAlign.Center
                )


                Text(
                    text = "Ingresa tu correo electrónico para enviarte un enlace de restablecimiento.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 32.dp),
                    textAlign = TextAlign.Center
                )


                TextField(
                    "Ingresa tu correo.",
                    {}

                )


                Spacer(modifier = Modifier.height(24.dp))


                Button(
                    onClick = { navController.navigate("CodePassword") },
                    modifier = Modifier.fillMaxWidth(),

                    ) {
                    Text("Restablecer Contraseña")
                }

                Spacer(modifier = Modifier.height(32.dp))


                Text(
                    text = "Volver al inicio de sesión",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .clickable { regresoLoginClick() }
                        .padding(8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewForgotScrren(){
    PostrecitoDeluxeTheme {
        ForgotPasswordScreen(rememberNavController(), viewModel ())
    }
}