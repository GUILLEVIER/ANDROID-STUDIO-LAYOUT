package com.guillevier.practiceandroidstudio.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.EditText
import android.widget.Button
import android.widget.LinearLayout
import android.text.InputType
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

// FUNCIONAL
class RegisterActivity : ComponentActivity() {
    private lateinit var textInputLayoutName: TextInputLayout
    private lateinit var textInputLayoutSurname: TextInputLayout
    private lateinit var textInputLayoutEmail: TextInputLayout
    private lateinit var textInputLayoutPassword: TextInputLayout
    private lateinit var textInputLayoutPasswordConfirm: TextInputLayout
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear un LinearLayout para contener los elementos
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        layout.setPadding(16, 16, 16, 16)

        // Crear TextInputLayouts para los campos del formulario
        textInputLayoutName = TextInputLayout(this).apply {
            hint = "Nombre"
        }
        textInputLayoutSurname = TextInputLayout(this).apply {
            hint = "Apellido"
        }
        textInputLayoutEmail = TextInputLayout(this).apply {
            hint = "Correo Electrónico"
        }
        textInputLayoutPassword = TextInputLayout(this).apply {
            hint = "Contraseña"
            editText?.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
        textInputLayoutPasswordConfirm = TextInputLayout(this).apply {
            hint = "Confirmar Contraseña"
            editText?.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        // Crear EditTexts y asignarlos a los TextInputLayouts
        val editTextName = EditText(this)
        val editTextSurname = EditText(this)
        val editTextEmail = EditText(this).apply {
            inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        }
        val editTextPassword = EditText(this).apply {
            inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
        val editTextPasswordConfirm = EditText(this).apply {
            inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        textInputLayoutName.addView(editTextName)
        textInputLayoutSurname.addView(editTextSurname)
        textInputLayoutEmail.addView(editTextEmail)
        textInputLayoutPassword.addView(editTextPassword)
        textInputLayoutPasswordConfirm.addView(editTextPasswordConfirm)

        // Crear el botón de registro
        buttonRegister = Button(this).apply {
            text = "Registrar Usuario"
            setOnClickListener { registerUser () }
        }

        // Agregar los TextInputLayouts y el botón al layout
        layout.addView(textInputLayoutName)
        layout.addView(textInputLayoutSurname)
        layout.addView(textInputLayoutEmail)
        layout.addView(textInputLayoutPassword)
        layout.addView(textInputLayoutPasswordConfirm)
        layout.addView(buttonRegister)

        // Establecer el layout como contenido de la actividad
        setContentView(layout)
    }

    private fun registerUser () {
        val name = (textInputLayoutName.editText?.text.toString().trim())
        val surname = (textInputLayoutSurname.editText?.text.toString().trim())
        val email = (textInputLayoutEmail.editText?.text.toString().trim())
        val password = (textInputLayoutPassword.editText?.text.toString().trim())
        val passwordConfirme = (textInputLayoutPasswordConfirm.editText?.text.toString().trim())

        // Validar los campos
        if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty() || passwordConfirme.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        // Validar el formato del email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Por favor, ingresa un correo electrónico válido.", Toast.LENGTH_SHORT).show()
            return
        }

        // Validar la contraseña (por ejemplo, longitud mínima)
        if (password.length < 6) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres.", Toast.LENGTH_SHORT).show()
            return
        }

        // Si todas las validaciones son correctas
        Toast.makeText(this, "Usuario Registrado.", Toast.LENGTH_SHORT).show()
        clearFields()
    }

    private fun clearFields() {
        textInputLayoutName.editText?.text?.clear()
        textInputLayoutSurname.editText?.text?.clear()
        textInputLayoutEmail.editText?.text?.clear()
        textInputLayoutPassword.editText?.text?.clear()
        textInputLayoutPasswordConfirm.editText?.text?.clear()
    }
}