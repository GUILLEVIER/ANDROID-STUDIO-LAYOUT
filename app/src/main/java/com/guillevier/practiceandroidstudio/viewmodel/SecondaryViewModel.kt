package com.guillevier.practiceandroidstudio.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondaryViewModel : ViewModel() {

    // LiveData para observar el mensaje
    private val _message = MutableLiveData<String>().apply { value = "¡Hola, Mundo!" }
    val message: LiveData<String> get() = _message

    // Método que se llama cuando se hace clic en el botón
    fun onButtonClicked() {
        _message.value = "¡Has hecho clic en el botón!"
    }
}