package mx.edu.utez.postrecitodeluxe.ui.components

import android.R.attr.x
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFilling
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFlavor
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeFrosting
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeShape
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeSize
import mx.edu.utez.postrecitodeluxe.ui.data.model.CakeTopping
import mx.edu.utez.postrecitodeluxe.ui.data.model.Pastel
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme

@Composable
fun PantallaPrincipal(p: Pastel, o: (Pastel)->Unit){
    Column {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clickable{o(p)}
        ){
            Column (
                modifier = Modifier.padding(16.dp)
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ){
                    Text(text = "Tus ordenes")

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun  PreviewPantallaPrincipal(){
    val p = Pastel(
        glaseado = CakeFrosting.STRAWBERRY,
        sabor = CakeFlavor.CHOCOLATE,
        topping = CakeTopping.STRAWBERRIES,
        forma = CakeShape.HEART,
        relleno = CakeFilling.VANILLA,
        tamanio = CakeSize.LARGE
    )
    PostrecitoDeluxeTheme {
        PantallaPrincipal(p) {print("Hola")}
    }
}