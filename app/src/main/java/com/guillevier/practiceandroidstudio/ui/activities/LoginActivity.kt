package com.guillevier.practiceandroidstudio.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.guillevier.practiceandroidstudio.R

// FUNCIONAL
class LoginActivity : ComponentActivity() {
    private lateinit var editTextUserName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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