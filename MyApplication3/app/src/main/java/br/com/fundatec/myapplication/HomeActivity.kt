package br.com.fundatec.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val image = findViewById<ImageView>(R.id.iv_home)

        //pode usar ou Glide ou Picasso
        Glide
            .with(this)
            .load("url")
            .into(image)

        Picasso
            .get()
            .load("url")
            .into(image)
    }

}