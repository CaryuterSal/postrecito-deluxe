package mx.edu.utez.postrecitodeluxe.ui.components.inputs

import android.R.attr.label
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.lifecycle.viewmodel.compose.viewModel
import mx.edu.utez.postrecitodeluxe.viewmodel.LoginViewModel
import mx.edu.utez.postrecitodeluxe.viewmodel.RegisterViewModel

@Composable
fun UserInputField(
    value: String,
    onValueChange: (String) -> Unit,
    onNext: (() -> Unit)? = null,
    label: String = "Correo")
  {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                onNext?.invoke() ?: focusManager.moveFocus(FocusDirection.Down)
            }
        )
    )
}
