package com.guillevier.practiceandroidstudio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    private lateinit var editTextUserName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        /*
        setContent {
            PracticeAndroidStudioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        */
        setContentView(R.layout.activity_main_linear_layout)

        // Inicializar los EditText y el Button
        editTextUserName = findViewById(R.id.user_input)
        editTextPassword = findViewById(R.id.user_password)
        buttonLogin = findViewById(R.id.login_button)

        // Configurar el listener del botón
        buttonLogin.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val userName = editTextUserName.text.toString().trim()
        val userPassword = editTextPassword.text.toString().trim()

        // Validar Campos
        if (userName.isEmpty() || userPassword.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        // Obtención de valores
        println("userName: $userName")
        println("userPassword: $userPassword")

        // Simulación de Registro Exitoso
        Toast.makeText(this, "Usuario registrado exitosamente.", Toast.LENGTH_SHORT).show()

        // Limpiar los campos después del registro.
        clearFields()
    }

    private fun clearFields() {
        editTextUserName.text.clear()
        editTextPassword.text.clear()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    /*
    PracticeAndroidStudioTheme {
        Greeting("Android")
    }
    */
}