package com.guillevier.practiceandroidstudio.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.guillevier.practiceandroidstudio.ui.theme.PracticeAndroidStudioTheme
import com.guillevier.practiceandroidstudio.viewmodel.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel(), navController: NavController) {
    var errorMessage by remember { mutableStateOf("") }
    var successMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = loginViewModel.userName,
            onValueChange = { loginViewModel.userName = it },
            label = { Text("Usuario") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = loginViewModel.userPassword,
            onValueChange = { loginViewModel.userPassword = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            loginViewModel.loginUser(
                onSuccess = {
                    successMessage = "Usuario Logeado."
                    errorMessage = ""
                    clearFields(loginViewModel)
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onError = { message ->
                    errorMessage = message
                    successMessage = ""
                }
            )
        }) {
            Text("Iniciar Sesión")
        }

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
        }

        if (successMessage.isNotEmpty()) {
            Text(text = successMessage, color = MaterialTheme.colorScheme.primary)
        }
    }
}

private fun clearFields(viewModel: LoginViewModel) {
    viewModel.userName = ""
    viewModel.userPassword = ""
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val loginViewModel: LoginViewModel = viewModel()
    val navController = rememberNavController()

    PracticeAndroidStudioTheme {
        LoginScreen(loginViewModel, navController)
    }
}