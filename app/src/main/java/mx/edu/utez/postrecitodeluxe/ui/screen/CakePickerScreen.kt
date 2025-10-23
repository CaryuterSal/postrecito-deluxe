package mx.edu.utez.postrecitodeluxe.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import mx.edu.utez.postrecitodeluxe.data.model.Cake
import mx.edu.utez.postrecitodeluxe.data.model.CakeFilling
import mx.edu.utez.postrecitodeluxe.data.model.CakeFlavor
import mx.edu.utez.postrecitodeluxe.data.model.CakeFrosting
import mx.edu.utez.postrecitodeluxe.data.model.CakeShape
import mx.edu.utez.postrecitodeluxe.data.model.CakeSize
import mx.edu.utez.postrecitodeluxe.data.model.CakeTopping
import mx.edu.utez.postrecitodeluxe.ui.components.CakePreview
import mx.edu.utez.postrecitodeluxe.ui.components.buttons.PrimaryButton
import mx.edu.utez.postrecitodeluxe.ui.components.buttons.SecondaryButton
import mx.edu.utez.postrecitodeluxe.ui.components.inputs.CakePickerRow
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import mx.edu.utez.postrecitodeluxe.viewmodel.CakeViewModel

@Composable
fun CakePickerScreen(
    cake: Cake,
    onUpdateProp: (Cake) -> Unit,
    modifier: Modifier = Modifier,
    saveButtonText: String = "Confirmar",
    onSave: (Cake) -> Unit,
    cancelButtonText: String = "Cancelar",
    onCancel: () -> Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(20.dp, 30.dp)
            .fillMaxSize()
    ){

        CakePreview(cake)

        Spacer(modifier = Modifier.height(30.dp))

        CakePickerRow(cake) {onUpdateProp(it)}

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            PrimaryButton(text = saveButtonText) {onSave(cake)}
            SecondaryButton(text = cancelButtonText) {onCancel()}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CakePickerScreenPreview(){
    val vm = viewModel<CakeViewModel>()
    var cake by remember { mutableStateOf(Cake(
        CakeFlavor.CHOCOLATE,
        CakeFrosting.VANILLA,
        CakeTopping.SPRINKLES,
        CakeFilling.CHOCOLATE,
        CakeSize.LARGE,
        CakeShape.SQUARE
    )) }
    PostrecitoDeluxeTheme {
        CakePickerScreen(
            cake = cake,
            onUpdateProp = {cake = it},
            saveButtonText = "Crear",
            onSave = vm::addCake,
            cancelButtonText = "Cancelar",
            onCancel = {println("Cancelado")} )
    }
}

