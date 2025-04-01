package com.guillevier.practiceandroidstudio.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.guillevier.practiceandroidstudio.R
import com.guillevier.practiceandroidstudio.databinding.SecondaryActivityBindingLayoutBinding
import com.guillevier.practiceandroidstudio.ui.viewmodels.SecondaryViewModel

// FUNCIONAL
class SecondaryActivity : ComponentActivity() {
    private lateinit var binding: SecondaryActivityBindingLayoutBinding
    private val viewModel: SecondaryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.secondary_activity_binding_layout)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Configurar el botón
        binding.button.setOnClickListener {
            viewModel.onButtonClicked()
        }
    }
}