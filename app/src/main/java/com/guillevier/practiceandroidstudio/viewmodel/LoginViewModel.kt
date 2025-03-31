package com.guillevier.practiceandroidstudio.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    var userName: String = ""
    var userPassword: String = ""

    fun loginUser (onSuccess: () -> Unit, onError: (String) -> Unit) {
        // Validar los campos
        if (userName.isEmpty() || userPassword.isEmpty()) {
            onError("Por favor, completa todos los campos.")
            return
        }

        // Si todas las validaciones son correctas
        viewModelScope.launch {
            // Aquí puedes agregar la lógica para validar el ingreso del usuario en la base de datos o API
            onSuccess()
        }
    }
}