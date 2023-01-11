package br.com.fundatec.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import br.com.fundatec.myapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tv_text).setOnClickListener {
            showToast()
            showSnack()
        }
    }

    private fun showToast() {
        Toast.makeText(this, "Olá!", Toast.LENGTH_SHORT)
    }

    private fun showSnack() {
        val container = findViewById<ConstraintLayout>(R.id.container)
        Snackbar
            .make(container, "Nosso snackbar", Snackbar.LENGTH_LONG)
            .setAction("OK") {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }
            .show()
    }

}