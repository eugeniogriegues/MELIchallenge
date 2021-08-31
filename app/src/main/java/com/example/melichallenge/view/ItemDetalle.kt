package com.example.melichallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.melichallenge.R

class ItemDetalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detalle)


        val price = findViewById<TextView>(R.id.output_detail_precio)
        val name = findViewById<TextView>(R.id.output_detail_nombre)
        val image = findViewById<ImageView>(R.id.output_detail_imagen)

        val extras = intent.extras

        price.text = "$ "+extras?.getInt("precio")
        name.text = extras?.getString("nombre")
        image.load(extras?.getString("imagen")?.replace("http://", "https://"))


    }



}