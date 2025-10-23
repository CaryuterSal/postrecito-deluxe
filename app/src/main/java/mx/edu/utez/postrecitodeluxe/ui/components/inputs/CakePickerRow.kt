package mx.edu.utez.postrecitodeluxe.ui.components.inputs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
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
fun CakePickerRow(
    cake: Cake,
    onUpdate: (Cake) -> Unit){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(80.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(
            listOf<@Composable () -> Unit>(
                { CakeLayerPicker("Tamaño", CakeSize::class, cake.tamanio) { onUpdate(cake.copy(tamanio = it)) } },
                { CakeLayerPicker("Forma", CakeShape::class, cake.forma) { onUpdate(cake.copy(forma = it)) } },
                { CakeLayerPicker("Sabor", CakeFlavor::class, cake.sabor) { onUpdate(cake.copy(sabor = it)) } },
                { CakeLayerPicker("Relleno", CakeFilling::class, cake.relleno) { onUpdate(cake.copy(relleno = it)) } },
                { CakeLayerPicker("Glaseado", CakeFrosting::class, cake.glaseado) { onUpdate(cake.copy(glaseado = it)) } },
                { CakeLayerPicker("Topping", CakeTopping::class, cake.topping) { onUpdate(cake.copy(topping = it)) } },
            )
        ) { pickerComposable ->
            pickerComposable()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CakePickerRowPreview(){
    val vm = viewModel<CakeViewModel>()
    vm.addCake(Cake(
        CakeFlavor.CHOCOLATE,
        CakeFrosting.VANILLA,
        CakeTopping.SPRINKLES,
        CakeFilling.CHOCOLATE,
        CakeSize.LARGE,
        CakeShape.SQUARE
    ))
    vm.selectCake(0)
    val cakes by vm.cakeList.collectAsStateWithLifecycle()
    val selectedCake by vm.selectedCake.collectAsStateWithLifecycle()
    PostrecitoDeluxeTheme {
        CakePickerRow(cakes[selectedCake!!], vm::updateCake)
    }
}