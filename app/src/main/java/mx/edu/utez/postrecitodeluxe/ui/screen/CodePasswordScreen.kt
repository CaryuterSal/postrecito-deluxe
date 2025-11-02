package mx.edu.utez.postrecitodeluxe.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import mx.edu.utez.postrecitodeluxe.viewmodel.CakeViewModel


@Composable
fun CodePasswordScreen(navController: NavController, viewModel: CakeViewModel = viewModel()){

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
                text = "Código de verificación",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )


            Text(
                text = "Recibiste un código de verificación de 5 digitos al correo registrado.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 32.dp),
                textAlign = TextAlign.Center
            )


            TextField(
                "Ingresa el código de verificación",
                {}

            )


            Spacer(modifier = Modifier.height(24.dp))


            Button(
                onClick = { navController.navigate("register") } ,
                modifier = Modifier.fillMaxWidth(),

                ) {
                Text("Enviar")
            }

            Spacer(modifier = Modifier.height(32.dp))


            Text(
                text = "Enviar nuevo código",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
}

@Preview(showBackground = true)
@Composable
fun PreviewCodeScrren(){
    PostrecitoDeluxeTheme {
        CodePasswordScreen(rememberNavController(), viewModel ())
    }
}

