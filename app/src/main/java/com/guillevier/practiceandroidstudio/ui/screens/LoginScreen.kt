package com.guillevier.practiceandroidstudio.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import com.guillevier.practiceandroidstudio.R

// FUNCIONAL
// ELEVACIÓN DE ESTADO: EXTRACCIÓN DE VALORES MUTABLES
// fun LoginScreen(loginViewModel: LoginViewModel = viewModel())
@Composable
fun LoginScreen() {
    var userName by rememberSaveable { mutableStateOf("") }
    var userPassword by rememberSaveable { mutableStateOf("") }
    var errorMessage by rememberSaveable { mutableStateOf("") }
    var successMessage by rememberSaveable { mutableStateOf("") }

    LoginContent(
        userName = userName,
        onUserNameChange = { userName = it },
        userPassword = userPassword,
        onUserPasswordChange = { userPassword = it },
        errorMessage = errorMessage,
        onErrorMessageChange = { errorMessage = it },
        successMessage = successMessage,
        onSuccessMessageChange = { successMessage = it })
}

@Preview(
    showBackground = true,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    device = "spec:id=reference_tablet,shape=Normal,width=1280,height=800,unit=dp,dpi=240",
    locale = "fr-rFR"
)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

@Composable
fun LoginContent(
    userName: String,
    onUserNameChange: (String) -> Unit,
    userPassword: String,
    onUserPasswordChange: (String) -> Unit,
    errorMessage: String,
    onErrorMessageChange: (String) -> Unit,
    successMessage: String,
    onSuccessMessageChange: (String) -> Unit,
) {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    Column(
        modifier = Modifier
            .padding(mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = userName,
            onValueChange = { onUserNameChange(it) },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = userPassword,
            onValueChange = { onUserPasswordChange(it) },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (userName.isEmpty() || userPassword.isEmpty()) {
                onErrorMessageChange("Por favor, completa todos los campos.")
                onSuccessMessageChange("")
            } else {
                onErrorMessageChange("")
                onSuccessMessageChange("Usuario Logeado.")
                onUserNameChange("")
                onUserPasswordChange("")
            }
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