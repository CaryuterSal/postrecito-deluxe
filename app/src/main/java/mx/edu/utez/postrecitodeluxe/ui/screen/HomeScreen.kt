package mx.edu.utez.postrecitodeluxe.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.postrecitodeluxe.data.model.Cake
import mx.edu.utez.postrecitodeluxe.ui.components.CakePreview
import mx.edu.utez.postrecitodeluxe.ui.components.buttons.PrimaryButton
import mx.edu.utez.postrecitodeluxe.ui.components.text.PropertyLabel
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import mx.edu.utez.postrecitodeluxe.viewmodel.CakeViewModel

@Composable
fun HomeScreen(viewModel: CakeViewModel ,navController: NavController) {

    val cakes by viewModel.cakeList.collectAsStateWithLifecycle()
    Column {
        PrimaryButton(text = "Crear nuevo") {navController.navigate("createCake")}
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
        ){
            items(cakes, Cake::hashCode){
                ElevatedCard(
                    onClick = {
                        viewModel.selectCake(cakes.indexOf(it))
                        navController.navigate("editCake")}
                ) {
                    CakePreview(it, size = 100.dp)
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    PostrecitoDeluxeTheme {
        HomeScreen(viewModel(), rememberNavController())
    }
}