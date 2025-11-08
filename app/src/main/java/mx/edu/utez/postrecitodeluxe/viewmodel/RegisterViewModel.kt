package mx.edu.utez.postrecitodeluxe.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    val username = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmPassword = mutableStateOf("")

    fun register(onSuccess: () -> Unit) {
        if (password.value == confirmPassword.value && password.value.isNotEmpty()) {
            onSuccess()
        } else {

        }
    }
}