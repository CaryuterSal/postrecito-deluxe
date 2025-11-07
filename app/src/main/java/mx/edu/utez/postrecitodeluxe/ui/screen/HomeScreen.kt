package mx.edu.utez.postrecitodeluxe.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.postrecitodeluxe.R
import mx.edu.utez.postrecitodeluxe.data.model.Cake
import mx.edu.utez.postrecitodeluxe.ui.components.CakeCard
import mx.edu.utez.postrecitodeluxe.ui.components.CakeList
import mx.edu.utez.postrecitodeluxe.ui.components.CakePreview
import mx.edu.utez.postrecitodeluxe.ui.components.buttons.PrimaryButton
import mx.edu.utez.postrecitodeluxe.ui.components.images.CircularImage
import mx.edu.utez.postrecitodeluxe.ui.components.text.PropertyLabel
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import mx.edu.utez.postrecitodeluxe.viewmodel.CakeViewModel

@Composable
fun HomeScreen(viewModel: CakeViewModel ,navController: NavController) {

    val cakesList by viewModel.cakeList.collectAsStateWithLifecycle()
    var searchText by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(R.drawable.usericon),
                contentDescription = "Ícono de usuario",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Bienvenido",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.cakeicon),
                contentDescription = "Ícono de pastel",
                modifier = Modifier.size(90.dp)
            )
            PrimaryButton(text = "Agregar"
            ) {navController.navigate("createCake")}
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Mis Pasteles",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
            placeholder = { Text("search") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        CakeList(lista = cakesList.filter {
            it.sabor.name.contains(searchText, ignoreCase = true)
        },
            onClick = {
            viewModel.selectCake(cakesList.indexOf(it))
            navController.navigate("editCake")
        })
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    PostrecitoDeluxeTheme {
        HomeScreen(viewModel(), rememberNavController())
    }
}