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

        //declaramos el textview
        horoscopotextview=findViewById(R.id.horoscopotextview)

        //recuperamos de la pantalla anterios
        var nombre=intent.getStringExtra("NOMBRE_HOROSCOPO")

        //escribimos en el textview
        horoscopotextview.text=nombre


    }
}