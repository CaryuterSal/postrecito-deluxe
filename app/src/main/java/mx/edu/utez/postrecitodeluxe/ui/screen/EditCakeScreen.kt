package mx.edu.utez.postrecitodeluxe.ui.screen

import android.text.Layout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.postrecitodeluxe.ui.components.CakePreview
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import mx.edu.utez.postrecitodeluxe.viewmodel.CakeViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mx.edu.utez.postrecitodeluxe.data.model.Cake
import mx.edu.utez.postrecitodeluxe.data.model.CakeFilling
import mx.edu.utez.postrecitodeluxe.data.model.CakeFlavor
import mx.edu.utez.postrecitodeluxe.data.model.CakeFrosting
import mx.edu.utez.postrecitodeluxe.data.model.CakeShape
import mx.edu.utez.postrecitodeluxe.data.model.CakeSize
import mx.edu.utez.postrecitodeluxe.data.model.CakeTopping
import mx.edu.utez.postrecitodeluxe.ui.components.buttons.DeleteButton

@Composable
fun EditCakeScreen(viewModel: CakeViewModel, navController: NavController){

    val cakes by viewModel.cakeList.collectAsStateWithLifecycle()

    val selectedIndex by viewModel.selectedCake.collectAsState()

    var cake by remember { mutableStateOf(cakes[selectedIndex!!].copy()) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CakePickerScreen(
            cake = cake,
            onUpdateProp = { cake = it },
            saveButtonText = "Guardar",
            onSave = {
                viewModel.updateCake(it)
                navController.navigate("home")
            },
            cancelButtonText = "Cancelar",
            onCancel = { navController.navigate("home") },
            modifier = Modifier.fillMaxSize()
        )

        DeleteButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(90.dp)
        ) {
            viewModel.deleteCake()
            navController.navigate("home")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun EditCakeScreenPreview(){
    val vm = viewModel<CakeViewModel>()
    vm.addCake(Cake(
        1,
        CakeFlavor.CHOCOLATE,
        CakeFrosting.VANILLA,
        CakeTopping.SPRINKLES,
        CakeFilling.CHOCOLATE,
        CakeSize.LARGE,
        CakeShape.SQUARE
    ))
    vm.selectCake(0)
    PostrecitoDeluxeTheme {
        EditCakeScreen(vm, rememberNavController())
    }
}