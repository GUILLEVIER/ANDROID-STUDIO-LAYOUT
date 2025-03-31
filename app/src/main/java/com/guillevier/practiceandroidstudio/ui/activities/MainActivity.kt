package com.guillevier.practiceandroidstudio.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.guillevier.practiceandroidstudio.viewmodel.RegisterViewModel
import com.guillevier.practiceandroidstudio.ui.screens.LoginScreen
import com.guillevier.practiceandroidstudio.ui.screens.RegisterScreen
import com.guillevier.practiceandroidstudio.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    private val registerViewModel: RegisterViewModel by viewModels()
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = NavigationRoutes.Register) {
                    composable(NavigationRoutes.Register) { RegisterScreen(registerViewModel, navController) }
                    composable(NavigationRoutes.Login) { LoginScreen(loginViewModel, navController) }
                }
            }
        }
    }
}

object NavigationRoutes {
    const val Register = "register"
    const val Login = "login"
    const val Home = "home"
    const val Calculator = "calculator"
}