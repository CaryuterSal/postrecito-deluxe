package mx.edu.utez.postrecitodeluxe.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.postrecitodeluxe.data.model.Cake
import mx.edu.utez.postrecitodeluxe.data.model.CakeFilling
import mx.edu.utez.postrecitodeluxe.data.model.CakeFlavor
import mx.edu.utez.postrecitodeluxe.data.model.CakeFrosting
import mx.edu.utez.postrecitodeluxe.data.model.CakeShape
import mx.edu.utez.postrecitodeluxe.data.model.CakeSize
import mx.edu.utez.postrecitodeluxe.data.model.CakeTopping
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme

@Preview (showBackground = true)
@Composable
fun CakeListPreview() {
    val lista = listOf(
        Cake(
            id = 1,
            sabor = CakeFlavor.CHOCOLATE,
            glaseado = CakeFrosting.CHOCOLATE,
            topping = CakeTopping.STRAWBERRIES,
            relleno = CakeFilling.CHOCOLATE,
            tamanio = CakeSize.MEDIUM,
            forma = CakeShape.HEART
        ),
        Cake(
            id = 2,
            sabor = CakeFlavor.CARROT,
            glaseado = CakeFrosting.VANILLA,
            topping = CakeTopping.SPRINKLES,
            relleno = CakeFilling.PASTRY_CREAM,
            tamanio = CakeSize.SMALL,
            forma = CakeShape.ROUND
        ),
        Cake(
            id = 3,
            sabor = CakeFlavor.VANILLA,
            glaseado = CakeFrosting.STRAWBERRY,
            topping = CakeTopping.STRAWBERRIES,
            relleno = CakeFilling.STRAWBERRY_JAM,
            tamanio = CakeSize.LARGE,
            forma = CakeShape.HEART
        ),
        Cake(
            id = 4,
            sabor = CakeFlavor.RED_VELVET,
            glaseado = CakeFrosting.CREAM,
            topping = CakeTopping.SPRINKLES,
            relleno = CakeFilling.PASTRY_CREAM,
            tamanio = CakeSize.SMALL,
            forma = CakeShape.SQUARE
        ),
        Cake(
            id = 5,
            sabor = CakeFlavor.VANILLA,
            glaseado = CakeFrosting.STRAWBERRY,
            topping = CakeTopping.COOKIES,
            relleno = CakeFilling.STRAWBERRY_JAM,
            tamanio = CakeSize.LARGE,
            forma = CakeShape.HEART
        )
    )
    PostrecitoDeluxeTheme {
        CakeList(lista) { }
    }

}

@Composable
fun CakeList(lista: List<Cake>, onClick: (Cake) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = lista, key = {it.id} ) {cake ->
            CakeCard(cake,onClick)
        }
    }
}