package com.example.whoapp

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterView

class PictureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        val bundle = intent.extras
        val idTitulo = bundle?.getInt("titulo")
        val textview : TextView = findViewById(R.id.textView3)
        textview.text = getString(idTitulo!!)

        val idImagen = bundle.getInt("image")
        val imageFilterView: ImageFilterView = findViewById(R.id.imageFilterView)
        imageFilterView.setImageResource(idImagen)



    }

}