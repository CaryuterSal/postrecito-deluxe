package mx.edu.utez.postrecitodeluxe.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.utez.postrecitodeluxe.R
import mx.edu.utez.postrecitodeluxe.data.model.Cake
import mx.edu.utez.postrecitodeluxe.data.model.CakeFilling
import mx.edu.utez.postrecitodeluxe.data.model.CakeFlavor
import mx.edu.utez.postrecitodeluxe.data.model.CakeFrosting
import mx.edu.utez.postrecitodeluxe.data.model.CakeShape
import mx.edu.utez.postrecitodeluxe.data.model.CakeSize
import mx.edu.utez.postrecitodeluxe.data.model.CakeTopping
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme

@Composable
fun CakeCard(cake: Cake, onClick: (Cake) -> Unit, modifier: Modifier = Modifier) {
    val cakeBgColor = Color(0xFFF5F8F0)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable{onClick(cake)},
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = cakeBgColor),
        shape = RoundedCornerShape(30.dp)
    ) {
       Row(
           modifier = Modifier.padding(20.dp),
       ){

           //Aqui va la imagen del pastel
           CakePreview(cake, size = 100.dp)

           Spacer(modifier = Modifier.width(16.dp))

           Column {
               Spacer(modifier = Modifier.height(16.dp))
               Text(
                   text = "Pastel",
                   fontWeight = FontWeight.Bold,
                   fontSize = 16.sp,
                   letterSpacing = 2.sp
               )
               Spacer(modifier = Modifier.height(16.dp))
               Text(
                   text = cake.sabor.toString() + " | " + cake.forma.toString() + " | " + cake.topping.toString(),
                   fontWeight = FontWeight.Normal,
                   fontSize = 8.sp,
                   letterSpacing = 2.sp
               )
           }

           Spacer(modifier = Modifier.width(16.dp))
           Spacer(modifier = Modifier.height(35.dp))

           Image(painter = painterResource(id = R.drawable.trash),
               contentDescription = "Eliminar pastel",
               modifier = Modifier.size(20.dp)
           )
       }
    }
}


@Preview (showBackground = true)
@Composable
fun PreviewCakeCard(){
    val c = Cake(
        id = 1,
        sabor = CakeFlavor.VANILLA,
        glaseado = CakeFrosting.CHOCOLATE,
        topping = CakeTopping.COOKIES,
        relleno = CakeFilling.STRAWBERRY_JAM,
        tamanio = CakeSize.MEDIUM,
        forma = CakeShape.HEART
    )
    PostrecitoDeluxeTheme {
        CakeCard(c,
            onClick = {}
        )
    }
}
