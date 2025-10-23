package mx.edu.utez.postrecitodeluxe.ui.components.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme
import mx.edu.utez.postrecitodeluxe.ui.theme.Primary


@Composable
fun PrimaryButton(modifier: Modifier = Modifier,text: String = "Confirmar", onClick: () -> Unit){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Primary))
    {
        Text(text)
    }
}


@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview(){
    PostrecitoDeluxeTheme {
        PrimaryButton { print("Se hizo click") }
    }
}