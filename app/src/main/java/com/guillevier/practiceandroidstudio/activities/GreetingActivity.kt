package com.guillevier.practiceandroidstudio.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.guillevier.practiceandroidstudio.ui.screens.GreetingScreen
import com.guillevier.practiceandroidstudio.ui.theme.PracticeAndroidStudioTheme

// FUNCIONAL
class GreetingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeAndroidStudioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                        innerPadding ->
                    GreetingScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}