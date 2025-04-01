package com.guillevier.practiceandroidstudio.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.guillevier.practiceandroidstudio.ui.screens.LoginScreen

// FUNCIONAL
class LoginActivityCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}
