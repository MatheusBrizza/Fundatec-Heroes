package br.com.fundatec.myapplication.profile.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.myapplication.databinding.ActivityProfileBinding
import br.com.fundatec.myapplication.login.view.LoginActivity
import br.com.fundatec.myapplication.profile.presentation.ProfileViewModel

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configProfileButton()
    }

    private fun configProfileButton() {
        binding.btnProfile.setOnClickListener {
            viewModel.saveUser()
            // TODO: logcat continua reclamando "lateinit property instance has not been initialized" em App.kt, mas pelo menos não crasha
            showLogin()
        }
    }

    private fun showLogin() {
        val intent = Intent(this@ProfileActivity,LoginActivity::class.java)
        startActivity(intent)
    }
}