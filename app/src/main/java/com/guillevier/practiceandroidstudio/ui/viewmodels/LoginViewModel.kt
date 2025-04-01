package com.guillevier.practiceandroidstudio.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// FUNCIONAL
class LoginViewModel: ViewModel() {

    // Se visualizan cambios, al momento de ingresar nuevos campos.
    var userName by mutableStateOf("")
    var userPassword by mutableStateOf("")
    var errorMessage by mutableStateOf("")
    var successMessage by mutableStateOf("")

    // No se visualizan cambios, ya que no se declara que son mutables.
    /*
    var userName: String = ""
    var userPassword: String = ""
    var errorMessage: String = ""
    var successMessage: String = ""
     */

    fun loginUser () {
        // Validar los campos
        if (userName.isEmpty() || userPassword.isEmpty()) {
            errorMessage = "Por favor, completa todos los campos."
            successMessage = ""
            return
        }

        // Si todas las validaciones son correctas
        viewModelScope.launch {
            // Aquí puedes agregar la lógica para validar el ingreso del usuario en la base de datos o API
            errorMessage = ""
            successMessage = "Usuario Logeado."
            userName = ""
            userPassword = ""
        }
    }

    fun updateUserName(newUserName: String) {
        userName = newUserName
    }

    fun updateUserPassword(newUserPassword: String) {
        userPassword = newUserPassword
    }
}