package com.guillevier.practiceandroidstudio.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.guillevier.practiceandroidstudio.ui.viewmodels.RegisterViewModel

// FUNCIONAL
@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel = viewModel(),
    navController: NavController
) {
    /*
    En la función RegisterScreen(), agrega una variable nueva llamada registerUiState.
    Usa el delegado by y llama a collectAsState() en uiState.
    Este enfoque garantiza que, cada vez que haya un cambio en el valor de uiState,
    se produzca una recomposición para los elementos componibles con el valor de registerUiState.
    */
    val registerUiState by registerViewModel.uiState.collectAsState()

    // OPCIONAL MENSAJES EN PANTALLA
    var errorMessage by remember { mutableStateOf("") }
    var successMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = registerUiState.name,
            singleLine = true,
            shape = shapes.large,
            onValueChange = { registerViewModel.updateName(it) },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface,
            ),
            isError = false,
        )
        OutlinedTextField(
            value = registerUiState.surname,
            singleLine = true,
            shape = shapes.large,
            onValueChange = { registerViewModel.updateSurname(it) },
            label = { Text("Apellido") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface,
            ),
            isError = false,
        )
        OutlinedTextField(
            value = registerUiState.email,
            singleLine = true,
            shape = shapes.large,
            onValueChange = { registerViewModel.updateEmail(it) },
            label = { Text("Correo Electrónico") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface,
            ),
            isError = false,
        )
        OutlinedTextField(
            value = registerUiState.password,
            singleLine = true,
            shape = shapes.large,
            onValueChange = { registerViewModel.updatePassword(it) },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface,
            ),
            isError = false,
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedButton(
            onClick = {
                registerViewModel.registerUser(
                    onSuccess = {
                        successMessage = "Usuario Registrado."
                        errorMessage = ""
                        // Redirigir a la pantalla de inicio de sesión
                        navController.navigate("login") {
                            // Opcional: Limpiar la pila de navegación si no quieres volver a la pantalla de registro
                            popUpTo("register") { inclusive = true }
                        }
                    },
                    onError = { message ->
                        errorMessage = message
                        successMessage = ""
                    }
                )
            },
            enabled = !registerUiState.isLoading
        ) {
            Text(if (registerUiState.isLoading) "Cargando..." else "Registrar")
        }

        // USANDO EL ERROR ALMACENADO EN EL STORE
        if (registerUiState.errorMessage != null) {
            Text(
                text = registerUiState.errorMessage!!,
                color = Color.Red,
                modifier = Modifier.padding(8.dp)
            )
        }

        // OPCIONAL MENSAJES EN PANTALLA
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = colorScheme.error)
        }

        if (successMessage.isNotEmpty()) {
            Text(text = successMessage, color = colorScheme.primary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    val navController = rememberNavController()
    RegisterScreen(navController = navController)
}