package com.guillevier.practiceandroidstudio.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    var name: String = ""
    var surname: String = ""
    var email: String = ""
    var password: String = ""

    fun registerUser (onSuccess: () -> Unit, onError: (String) -> Unit) {
        // Validar los campos
        if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty()) {
            onError("Por favor, completa todos los campos.")
            return
        }

        // Validar el formato del email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            onError("Por favor, ingresa un correo electrónico válido.")
            return
        }

        // Validar la contraseña
        if (password.length < 6) {
            onError("La contraseña debe tener al menos 6 caracteres.")
            return
        }

        // Si todas las validaciones son correctas
        viewModelScope.launch {
            // Aquí puedes agregar la lógica para guardar el usuario en la base de datos o API
            onSuccess()
        }
    }
}