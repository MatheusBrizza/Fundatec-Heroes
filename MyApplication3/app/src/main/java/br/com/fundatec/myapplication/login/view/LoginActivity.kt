package br.com.fundatec.myapplication.login.view


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
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
                is ViewState.ShowHome -> showHome()
                is ViewState.ShowErrorFields -> showSnack(binding.root, "campos não devem estar vazios")
                is ViewState.ShowErrorEmail -> showToast("email incorreto")
                is ViewState.ShowErrorPassword -> showToast("senha incorreta")
            }
        }
        configLoginButton()
        configProfileButton()
    }

    private fun configLoginButton() {
        binding.btnLogin.setOnClickListener {
            viewModel.validateUserInput(
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString(),
            )
        }
    }

    private fun configProfileButton() {
        binding.tvNovoUsuario.setOnClickListener {
            showProfile()
        }
    }

    private fun showHome() {
        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
    }

    private fun showProfile() {
        startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
    }
}