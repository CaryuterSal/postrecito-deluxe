package mx.edu.utez.postrecitodeluxe.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
fun CakePreview(cake: Cake, modifier: Modifier = Modifier, size: Dp = 200.dp){
    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(cake.forma.previewImageRes),
            contentDescription = null,
            colorFilter = ColorFilter.tint(cake.sabor.color),
            modifier = Modifier
                .size(size * 0.25f)
                .align(Alignment.TopStart)
                .padding(size * 0.05f)
        )
        Image(
            painter = painterResource(cake.tamanio.previewImageRes),
            contentDescription = null,
            colorFilter = ColorFilter.tint(cake.sabor.color)
        )

        Image(
            painter = painterResource(when(cake.tamanio){
                CakeSize.SMALL -> R.drawable.filling_small
                CakeSize.MEDIUM -> R.drawable.filling_medium
                CakeSize.LARGE -> R.drawable.filling_big
            }),
            contentDescription = null,
            colorFilter = ColorFilter.tint(cake.relleno.color)
        )

        Image(
            painter = painterResource(when(cake.tamanio){
                CakeSize.SMALL -> R.drawable.frosting_small
                CakeSize.MEDIUM -> R.drawable.frosting_medium
                CakeSize.LARGE -> R.drawable.frosting_big
            }),
            contentDescription = null,
            colorFilter = ColorFilter.tint(cake.glaseado.color)
        )

        if(cake.topping == CakeTopping.SPRINKLES){
            Image(
                painter = painterResource(when(cake.tamanio){
                    CakeSize.SMALL -> R.drawable.sprinkles_small
                    CakeSize.MEDIUM -> R.drawable.sprinkles_medium
                    CakeSize.LARGE -> R.drawable.sprinkles_big
                }),
                contentDescription = null
            )
        } else {
            Image(
                painter = painterResource(when(cake.tamanio){
                    CakeSize.SMALL -> R.drawable.topping_small
                    CakeSize.MEDIUM -> R.drawable.topping_medium
                    CakeSize.LARGE -> R.drawable.topping_big
                }),
                contentDescription = null,
                colorFilter = ColorFilter.tint(cake.topping.color)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CakePreviewPreview(){
    val cake = Cake(
        1,
        CakeFlavor.RED_VELVET,
        CakeFrosting.VANILLA,
        CakeTopping.SPRINKLES,
        CakeFilling.CHOCOLATE,
        CakeSize.LARGE,
        CakeShape.ROUND
    )
    PostrecitoDeluxeTheme {
        CakePreview(cake, size = 100.dp)
    }
}