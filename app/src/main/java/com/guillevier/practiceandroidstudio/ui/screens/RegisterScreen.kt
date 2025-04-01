package com.guillevier.practiceandroidstudio.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.guillevier.practiceandroidstudio.ui.viewmodels.RegisterViewModel

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = viewModel(), navController: NavController) {
    var errorMessage by remember { mutableStateOf("") }
    var successMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = "",
            singleLine = true,
            shape = shapes.large,
            onValueChange = { },
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
            value = "",
            singleLine = true,
            shape = shapes.large,
            onValueChange = { },
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
            value = "",
            singleLine = true,
            shape = shapes.large,
            onValueChange = { },
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
            value = "",
            singleLine = true,
            shape = shapes.large,
            onValueChange = { },
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
        OutlinedButton(onClick = {
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
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    val registerViewModel: RegisterViewModel = viewModel()
    val navController = rememberNavController()
    RegisterScreen(registerViewModel, navController)
}