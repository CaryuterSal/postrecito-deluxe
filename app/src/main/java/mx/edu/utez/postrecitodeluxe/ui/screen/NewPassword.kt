package mx.edu.utez.postrecitodeluxe.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
fun NewPassword(navController: NavController, viewModel: CakeViewModel = viewModel()){

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
                    text = "Cambiar contraseña",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 32.dp),
                    textAlign = TextAlign.Center
                )


                Text(
                    text = "Ingresa una nueva contraseña.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 10.dp),
                    textAlign = TextAlign.Center
                )


                TextField(
                    "Nueva contraseña",
                    {}

                )
                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Confirmar contraseña.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 10.dp),
                    textAlign = TextAlign.Center
                )


                TextField(
                    "Confirmar contraseña",
                    {}

                )


                Spacer(modifier = Modifier.height(24.dp))


                Button(
                    onClick = { navController.navigate("register") } ,
                    modifier = Modifier.fillMaxWidth(),

                    ) {
                    Text("Cambiar contraseña")
                }

                Spacer(modifier = Modifier.height(32.dp))



            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewScreen(){
    PostrecitoDeluxeTheme {
        NewPassword(rememberNavController(), viewModel ())
    }
}

