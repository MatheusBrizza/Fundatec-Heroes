package br.com.fundatec.myapplication.login.view


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import br.com.fundatec.components.showSnack
import br.com.fundatec.components.showToast
import br.com.fundatec.myapplication.home.view.HomeActivity
import br.com.fundatec.myapplication.databinding.ActivityLoginBinding
import br.com.fundatec.myapplication.login.presentation.LoginViewModel
import br.com.fundatec.myapplication.login.presentation.ViewState
import br.com.fundatec.myapplication.profile.view.ProfileActivity

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etEmail.error = "Campo obrigatório"
        binding.etPassword.error = "Campo obrigatório"


        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowSuccess -> ShowSucess()
                is ViewState.ShowErrorFields -> showErrorFields()
                is ViewState.ShowErrorEmail -> showErrorEmail()
                is ViewState.ShowErrorPassword -> showErrorPassword()
                is ViewState.Loading -> loading()
            }
        }
        configLoginButton()
        configProfileButton()
    }

    private fun configLoginButton() {
        binding.btnLogin.setOnClickListener {
            viewModel.validateAndSaveUserInput(
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString()
            )
        }
    }

    private fun configProfileButton() {
        binding.btnNovoUsuario.setOnClickListener {
            goToProfile()
        }
    }

    private fun loading() {
        binding.pbLoading.isVisible = true
    }

    private fun showErrorFields() {
        binding.pbLoading.isVisible = false
        showSnack(binding.root,"Campos não devem estar vazios")
    }

    private fun showErrorEmail() {
        binding.pbLoading.isVisible = false
        showToast("Email incorreto")
    }

    private fun showErrorPassword() {
        binding.pbLoading.isVisible = false
        showToast("Senha incorreta")
    }

    private fun ShowSucess() {
        binding.pbLoading.isVisible = false
        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
    }

    private fun goToProfile() {
        startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
    }
}