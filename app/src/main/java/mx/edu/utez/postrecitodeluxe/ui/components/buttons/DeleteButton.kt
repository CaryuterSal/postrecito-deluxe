package mx.edu.utez.postrecitodeluxe.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.postrecitodeluxe.R
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import mx.edu.utez.postrecitodeluxe.ui.theme.Primary


@Composable
fun DeleteButton(modifier: Modifier = Modifier, onDelete: () -> Unit){
    Button(
        onClick = onDelete,
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        modifier = modifier
            .size(100.dp)
            .background(Color.Transparent, shape = CircleShape))
    {
        Image(  painter = painterResource(R.drawable.delete),
            contentDescription = "Eliminar")
        Icon(
            painter = painterResource(R.drawable.delete),
            contentDescription = "Eliminar")
    }
}

@Preview(showBackground = true)
@Composable
fun DeleteButtonPreview(){
    PostrecitoDeluxeTheme {
        DeleteButton {print("nonono")}
    }
}