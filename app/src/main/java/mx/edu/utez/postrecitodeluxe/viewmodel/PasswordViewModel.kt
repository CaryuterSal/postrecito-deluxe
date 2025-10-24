package mx.edu.utez.postrecitodeluxe.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PasswordViewModel : ViewModel() {
    var forgotPasswordEmail by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    var message by mutableStateOf<String?>(null)
    fun sendPasswordReset(onSuccess: () -> Unit) {
            if (forgotPasswordEmail.trim().isEmpty()) {
                message = "Por favor, ingrese un correo electrónico."
                return
            }

            viewModelScope.launch {
                isLoading = true
                message = null


                    if (forgotPasswordEmail.contains("fail", ignoreCase = true)) {
                        message = "Error: El correo electrónico no está registrado."
                    } else {
                        message = "Enlace enviado exitosamente. Revisa tu bandeja de entrada."
                        onSuccess()

            }
        }

            fun clearMessage() {
            message = null
        }

    }
}