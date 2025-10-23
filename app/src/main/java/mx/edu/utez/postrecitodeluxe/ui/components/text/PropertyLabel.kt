package mx.edu.utez.postrecitodeluxe.ui.components.text

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import mx.edu.utez.postrecitodeluxe.ui.theme.PostrecitoDeluxeTheme

@Composable
fun PropertyLabel(
    name: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color.Gray
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PickerPropertyTextPreview(){
    PostrecitoDeluxeTheme {
        PropertyLabel("Relleno", "Fresa")
    }
}