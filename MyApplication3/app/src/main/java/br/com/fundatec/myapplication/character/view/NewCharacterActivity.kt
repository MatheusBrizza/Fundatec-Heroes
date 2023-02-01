package br.com.fundatec.myapplication.character.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.net.URL
import java.time.LocalDate

class NewCharacterActivity: AppCompatActivity() {

    private val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}

data class Character (
    val name: String,
    val description: String,
    val age: Int,
    val date: LocalDate,
    val url: String,
    val dcMarvel: Spinner,
    val heroVilan: Spinner,
)