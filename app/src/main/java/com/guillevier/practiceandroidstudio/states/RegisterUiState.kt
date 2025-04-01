package com.guillevier.practiceandroidstudio.states

/*
Corresponde a valores mutables protegidos.
Manejar los estados de carga y error
*/
data class RegisterUiState(
    val name: String = "",
    val surname: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
