package mx.edu.utez.postrecitodeluxe.ui.data.viewmodel

import androidx.compose.runtime.mutableStateOf

class LoginViewModel {
    var password = mutableStateOf("")
    var username = mutableStateOf("")
    var loginError = mutableStateOf("")

    fun login(onSuccess: () -> Unit) {
        if (username.value == "admin" && password.value == "123") {
            loginError.value = ""
            onSuccess()
        } else {
            loginError.value = "Usuario o contraseña incorrectos"
        }
    }
}