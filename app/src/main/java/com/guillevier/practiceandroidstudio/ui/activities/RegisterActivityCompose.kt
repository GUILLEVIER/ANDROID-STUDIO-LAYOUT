package com.guillevier.practiceandroidstudio.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.guillevier.practiceandroidstudio.ui.screens.RegisterScreen

class RegisterActivityCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterScreen(navController = rememberNavController())
        }
    }
}