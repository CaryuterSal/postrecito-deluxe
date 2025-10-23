package mx.edu.utez.postrecitodeluxe.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import mx.edu.utez.postrecitodeluxe.ui.theme.Secondary

@Composable
fun SecondaryButton(modifier: Modifier = Modifier, text: String = "Cancelar", onClick: () -> Unit){
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(Secondary))
    {
        Text(text)
    }
}


@Preview(showBackground = true)
@Composable
fun SecondaryButtonPreview(){
    PostrecitoDeluxeTheme {
        SecondaryButton { print("Se hizo click") }
    }
}