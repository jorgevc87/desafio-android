package com.code.desafio.android.presentation.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.code.desafio.android.presentation.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: LoginViewModel

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservables()
        setupListener()
    }

    private fun setupObservables() {
        viewModel.isLoading.observe(this) {

            val msg = if (it) {
                "Comenzó carga"
            } else {
                "terminó carga"
            }

            Toast.makeText(this@LoginActivity, msg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupListener() {

    }


}