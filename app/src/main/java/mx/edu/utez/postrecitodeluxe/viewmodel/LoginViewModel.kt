package mx.edu.utez.postrecitodeluxe.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    var password = mutableStateOf("")

    val email = mutableStateOf("")
    var loginError = mutableStateOf("")

    fun login(onSuccess: () -> Unit) {
        if (email.value == "admin" && password.value == "123") {
            loginError.value = ""
            onSuccess()
        } else {
            loginError.value = "Usuario o contraseña incorrectos"
        }
    }
}