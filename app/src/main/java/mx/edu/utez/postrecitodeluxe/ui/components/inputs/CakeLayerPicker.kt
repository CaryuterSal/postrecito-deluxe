package mx.edu.utez.postrecitodeluxe.ui.components.inputs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import mx.edu.utez.postrecitodeluxe.data.model.CakeFilling
import mx.edu.utez.postrecitodeluxe.data.model.CakeOption
import mx.edu.utez.postrecitodeluxe.data.model.CakeSize
import mx.edu.utez.postrecitodeluxe.ui.components.text.PropertyLabel
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import kotlin.enums.enumEntries
import kotlin.reflect.KClass

@Composable
fun <T>CakeLayerPicker(
    propName: String,
    optionClass: KClass<T>,
    selectedOption: T,
    modifier: Modifier = Modifier,
    imageSize: Dp = 80.dp,
    onSelectedChange: (T) -> Unit,
)  where T: CakeOption, T: Enum<T>{
    val options = optionClass.java.enumConstants!!
    val selectedIndex = options.indexOf(selectedOption)

    val listState = rememberLazyListState()

    fun move(offset: Int) {
        val next = options[(selectedIndex + offset + options.size) % options.size]
        onSelectedChange(next)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(imageSize * 1.2f)) {

        Box(
            modifier = Modifier.height(60.dp)
        ){
            PropertyLabel(
                name = propName,
                value =selectedOption.toString(),
                modifier = Modifier.fillMaxWidth())
        }

        IconButton(onClick = {move(1)}) {
            Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Anterior")
        }


        Box(
            modifier = Modifier
                .size(width = imageSize * 1.2f, height = imageSize * 1.1f)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(selectedOption.icon),
                contentDescription = "Imagen seleccionada",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(imageSize)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

        IconButton(onClick = {move(-1)}) {
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Siguiente")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CakeLayerPickerPreview(){

    var selection by remember { mutableStateOf(CakeFilling.PASTRY_CREAM) }

    PostrecitoDeluxeTheme {
        CakeLayerPicker("Relleno", CakeFilling::class, selection, onSelectedChange = {selection = it})
    }
}
