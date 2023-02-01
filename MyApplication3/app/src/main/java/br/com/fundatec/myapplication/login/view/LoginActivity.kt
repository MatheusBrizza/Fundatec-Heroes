package br.com.fundatec.myapplication.login.view


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.fundatec.myapplication.home.view.HomeActivity
import br.com.fundatec.myapplication.R
import br.com.fundatec.myapplication.databinding.ActivityLoginBinding
import br.com.fundatec.myapplication.login.presentation.LoginViewModel
import br.com.fundatec.myapplication.login.presentation.ViewState
import com.google.android.material.snackbar.Snackbar
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import br.com.fundatec.myapplication.character.view.Character

class LoginActivity : AppCompatActivity() {

    private val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    /*private val character by lazy {
        Character("Batata", "asd")
    }
*/
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*
        val preferences = getSharedPreferences("bd", MODE_PRIVATE)
        val characterString = moshi.adapter(Character::class.java).toJson(character)
        preferences.edit().putString("character", characterString).commit()
*/
        binding.etEmail.error = "Campo obrigatório"

        configLoginButton()
        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowHome -> showHome()
                is ViewState.ShowError -> showSnack()
                is ViewState.ShowErrorEmail -> {}
                is ViewState.ShowErrorPassword -> {}
            }
        }
    }

        private fun configLoginButton() {
            binding.btnLogin.setOnClickListener {
                viewModel.validateUserInput(
                    email = binding.etEmail.text.toString(),
                    password = binding.etPassword.text.toString(),
                )
            }
        }


//        findViewById<TextView>(R.id.tv_text).setOnClickListener {
//            showToast()
//            showSnack()
//        }
//    }

    private fun showToast() {
        Toast.makeText(this, "Olá!", Toast.LENGTH_SHORT)
    }

    private fun showSnack() {
        val container = findViewById<ConstraintLayout>(R.id.container)
        Snackbar
            .make(container, "Nosso snackbar", Snackbar.LENGTH_LONG)
            .setAction("OK") {
                showHome()
            }
            .show()
    }

    private fun showHome() {
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intent)
    }
}