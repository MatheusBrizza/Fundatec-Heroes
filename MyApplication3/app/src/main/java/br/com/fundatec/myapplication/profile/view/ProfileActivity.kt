package br.com.fundatec.myapplication.profile.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import br.com.fundatec.components.showSnack
import br.com.fundatec.components.showToast
import br.com.fundatec.myapplication.databinding.ActivityProfileBinding
import br.com.fundatec.myapplication.login.view.LoginActivity
import br.com.fundatec.myapplication.profile.presentation.ProfileViewModel
import br.com.fundatec.myapplication.profile.presentation.ViewState

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowSuccess -> showSuccess()
                is ViewState.ShowError -> showError()
                is ViewState.ShowErrorName -> showErrorName()
                is ViewState.ShowErrorEmail -> showErrorEmail()
                is ViewState.ShowErrorPassword -> showErrorPassword()
                is ViewState.Loading -> OnLoading()
            }
        }
        configProfileButton()
    }

    private fun configProfileButton() {
        binding.btnProfile.setOnClickListener {
            viewModel.validateUserInput(
                name = binding.etName.text.toString(),
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString()
            )
        }
    }

    private fun showSuccess() {
        binding.pbLoading.isVisible = false
        showSnack(binding.root, "usuario cadastrado com sucesso")
        returnLogin()
    }

    private fun OnLoading() {
        binding.pbLoading.isVisible = true
    }

    private fun showError() {
        binding.pbLoading.isVisible = false
        showSnack(binding.root, "campos não devem estar vazios")
    }

    private fun showErrorName() {
        binding.pbLoading.isVisible = false
        showToast("nome não deve estar vazio")
    }

    private fun showErrorEmail() {
        binding.pbLoading.isVisible = false
        showToast("email no formato incorreto")
    }

    private fun showErrorPassword() {
        binding.pbLoading.isVisible = false
        showToast("senha no formato incorreto")
    }

    private fun returnLogin() {
        startActivity(Intent(this@ProfileActivity, LoginActivity::class.java))
    }
}