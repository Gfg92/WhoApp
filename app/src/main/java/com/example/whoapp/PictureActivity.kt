package com.example.whoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PictureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        val bandle = intent.extras
        val mensaje = bandle?.getString("hola")
        val textview : TextView = findViewById(R.id.textView3)
        textview.text = mensaje
    }

}