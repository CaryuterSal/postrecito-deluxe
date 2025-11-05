package mx.edu.utez.postrecitodeluxe.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.postrecitodeluxe.data.model.Cake
import mx.edu.utez.postrecitodeluxe.data.model.CakeFilling
import mx.edu.utez.postrecitodeluxe.data.model.CakeFlavor
import mx.edu.utez.postrecitodeluxe.data.model.CakeFrosting
import mx.edu.utez.postrecitodeluxe.data.model.CakeShape
import mx.edu.utez.postrecitodeluxe.data.model.CakeSize
import mx.edu.utez.postrecitodeluxe.data.model.CakeTopping
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import mx.edu.utez.postrecitodeluxe.viewmodel.CakeViewModel

@Composable
fun CreateCakeScreen(viewModel: CakeViewModel, navController: NavController){

    var cake by remember { mutableStateOf(Cake(
        sabor = CakeFlavor.CHOCOLATE,
        glaseado = CakeFrosting.VANILLA,
        topping = CakeTopping.SPRINKLES,
        relleno = CakeFilling.CHOCOLATE,
        tamanio = CakeSize.LARGE,
        forma = CakeShape.SQUARE
    )) }
    CakePickerScreen(
        cake = cake,
        onUpdateProp = {cake = it},
        saveButtonText = "Crear",
        onSave = {
            viewModel.addCake(it)
            navController.navigate("home")
        },
        cancelButtonText = "Cancelar",
        onCancel = {navController.navigate("home")} )
}

@Preview(showBackground = true)
@Composable
fun CreateCakeScreenPreview(){
    PostrecitoDeluxeTheme {
        CreateCakeScreen(viewModel(), rememberNavController())
    }
}