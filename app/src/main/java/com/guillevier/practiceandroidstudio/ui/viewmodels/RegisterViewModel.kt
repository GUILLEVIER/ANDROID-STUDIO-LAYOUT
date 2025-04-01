package com.guillevier.practiceandroidstudio.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guillevier.practiceandroidstudio.states.RegisterUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/*
Almacenar el estado de la IU del registro (name, surname, email, password).
 */
// FUNCIONAL
class RegisterViewModel : ViewModel() {
    /*
    En el archivo RegisterViewModel.kt,
    agrega una propiedad de copia de seguridad a uiState llamada _uiState.
    Asigna el nombre uiState a la propiedad, que es del tipo StateFlow<RegisterUiState>.
    Ahora _uiState solo es accesible y editable dentro de RegisterViewModel.
    La IU puede leer su valor usando la propiedad uiState de solo lectura.
    Establece uiState en _uiState.asStateFlow().
    El asStateFlow() hace que este flujo de estado mutable sea de solo lectura.
    */

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun registerUser(onSuccess: () -> Unit, onError: (String) -> Unit) {
        // Inicia la carga...
        _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
        // Validar los campos
        if (_uiState.value.name.isEmpty() || _uiState.value.surname.isEmpty() || _uiState.value.email.isEmpty() || _uiState.value.password.isEmpty()) {
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                errorMessage = "Por favor, completa todos los campos."
            )
            onError("Por favor, completa todos los campos.")
            return
        }

        // Validar el formato del email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(_uiState.value.email).matches()) {
            // REEMPLAZA EL STATE POR COMPLETO
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                errorMessage = "Por favor, ingresa un correo electrónico válido."
            )
            onError("Por favor, ingresa un correo electrónico válido.")
            return
        }

        // Validar la contraseña
        if (_uiState.value.password.length < 6) {
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                errorMessage = "La contraseña debe tener al menos 6 caracteres."
            )
            onError("La contraseña debe tener al menos 6 caracteres.")
            return
        }

        // Si todas las validaciones son correctas
        viewModelScope.launch {
            // Aquí puedes agregar la lógica para guardar el usuario en la base de datos o API
            // Simulando una llamada a la API
            delay(2000) // Simulación de carga
            _uiState.value = _uiState.value.copy(isLoading = false)
            onSuccess()
        }
    }

    fun updatePassword(it: String) {
        // MANERA SEGURA DE ACTUALIZAR EL STATE (CONCURRENCIAS)
        _uiState.update { currentState ->
            currentState.copy(
                password = it
            )
        }
    }

    fun updateEmail(it: String) {
        _uiState.update { currentState ->
            currentState.copy(
                email = it
            )
        }
    }

    fun updateSurname(it: String) {
        _uiState.update { currentState ->
            currentState.copy(
                surname = it
            )
        }
    }

    fun updateName(it: String) {
        _uiState.update { currentState ->
            currentState.copy(
                name = it
            )
        }
    }
}