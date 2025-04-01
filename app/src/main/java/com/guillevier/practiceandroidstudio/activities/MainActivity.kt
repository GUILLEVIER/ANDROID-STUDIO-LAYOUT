package com.guillevier.practiceandroidstudio.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.guillevier.practiceandroidstudio.ui.viewmodels.RegisterViewModel
import com.guillevier.practiceandroidstudio.ui.screens.LoginScreen
import com.guillevier.practiceandroidstudio.ui.screens.RegisterScreen
import com.guillevier.practiceandroidstudio.ui.theme.PracticeAndroidStudioTheme
import com.guillevier.practiceandroidstudio.ui.viewmodels.LoginViewModel

class MainActivity : ComponentActivity() {
    private val registerViewModel: RegisterViewModel by viewModels()
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeAndroidStudioTheme {
                Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = NavigationRoutes.Register) {
                        composable(NavigationRoutes.Register) { RegisterScreen(registerViewModel, navController) }
                        composable(NavigationRoutes.Login) { LoginScreen() }
                    }
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