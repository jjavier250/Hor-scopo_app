package com.example.horoscopo_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.horoscopo_app.R

class detalleHoroscopo : AppCompatActivity() {

    lateinit var horoscopotextview:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_horoscopo)

        var nombre=intent.getStringExtra("NOMBRE_HOROSCOPO")

        horoscopotextview=findViewById(R.id.horoscopotextview)

        horoscopotextview.text=nombre


    }
}