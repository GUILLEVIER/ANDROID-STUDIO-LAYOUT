package com.guillevier.practiceandroidstudio.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.guillevier.practiceandroidstudio.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = viewModel(), navController: NavController) {
    var errorMessage by remember { mutableStateOf("") }
    var successMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = registerViewModel.name,
            onValueChange = { registerViewModel.name = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = registerViewModel.surname,
            onValueChange = { registerViewModel.surname = it },
            label = { Text("Apellido") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = registerViewModel.email,
            onValueChange = { registerViewModel.email = it },
            label = { Text("Correo Electrónico") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = registerViewModel.password,
            onValueChange = { registerViewModel.password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        TextField(
            value = registerViewModel.rut,
            onValueChange = { registerViewModel.rut = it },
            label = { Text("RUT") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            registerViewModel.registerUser (
                onSuccess = {
                    successMessage = "Usuario Registrado."
                    errorMessage = ""
                    clearFields(registerViewModel)
                    navController.navigate("login") {
                        popUpTo("register") { inclusive = true }
                    }
                },
                onError = { message ->
                    errorMessage = message
                    successMessage = ""
                }
            )
        }) {
            Text("Registrar")
        }

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
        }

        if (successMessage.isNotEmpty()) {
            Text(text = successMessage, color = MaterialTheme.colorScheme.primary)
        }
    }
}

private fun clearFields(viewModel: RegisterViewModel) {
    viewModel.name = ""
    viewModel.surname = ""
    viewModel.email = ""
    viewModel.password = ""
    viewModel.rut = ""
}