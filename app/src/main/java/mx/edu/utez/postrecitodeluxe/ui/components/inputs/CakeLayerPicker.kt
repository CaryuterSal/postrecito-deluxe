package mx.edu.utez.postrecitodeluxe.ui.components.inputs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mx.edu.utez.postrecitodeluxe.R
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme

@Composable
fun CakeLayerPicker(
    images: List<Int>,
    selectedIndex: Int,
    onSelectedChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    imageSize: Dp = 80.dp
) {
    fun move(offset: Int) {
        val next = (selectedIndex + offset + images.size) % images.size
        onSelectedChange(next)
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        IconButton(onClick = { move(-1) }) {
            Icon(
                painter = painterResource(R.drawable.ic_triangle),
                contentDescription = "Anterior",
                tint = Color.Gray,
                modifier = Modifier
                    .rotate(270f)
                    .size(24.dp)
            )
        }


        Box(
            modifier = Modifier
                .size(width = imageSize * 1.2f, height = imageSize * 1.1f)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(images[selectedIndex]),
                contentDescription = "Imagen seleccionada",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(imageSize)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

        IconButton(onClick = { move(1) }) {
            Icon(
                painter = painterResource(R.drawable.ic_triangle),
                contentDescription = "Siguiente",
                tint = Color.Gray,
                modifier = Modifier
                    .rotate(90f)
                    .size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CakeLayerPickerPreview(){

    val options = listOf(
        R.drawable.strawberryjam,
        R.drawable.chocolate,
        R.drawable.vanilla
    )

    var selection by remember { mutableIntStateOf(0) }

    PostrecitoDeluxeTheme {
        CakeLayerPicker(options, selection, onSelectedChange = {selection = it})
    }
}
