package br.com.fundatec.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById<ConstraintLayout>(R.id.container)

        findViewById<TextView>(R.id.tv_text).apply {
            setOnClickListener {
                /*
                viewModel.changeText("novo modelo")*/
            Snackbar
                .make(container, "Nosso snackbar", Snackbar.LENGTH_LONG)
                .setAction("OK") {
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(intent)
                }
                .show()
            }
        }

 //       viewModel.newText.observe(this) { newText ->


    }
}