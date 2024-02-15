package com.example.horoscopo_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo_app.R
import com.example.horoscopo_app.adapters.HoroscopoAdapter
import com.example.horoscopo_app.data.Horoscopo

class MainActivity : AppCompatActivity() {


    val listaDeHoroscopos = listOf(
        Horoscopo(R.drawable.aries, R.string.Horoscopo_name_Aries),
        Horoscopo(R.drawable.tauro, R.string.Horoscopo_name_Tauro),
        Horoscopo(R.drawable.sagitario, R.string.Horoscopo_name_Sagitario),
        Horoscopo(R.drawable.cancer,R.string.Horoscopo_name_Cancer),
        Horoscopo(R.drawable.escorpio,R.string.Horoscopo_name_Escorpio),
        Horoscopo(R.drawable.leo,R.string.Horoscopo_name_Leo),
        Horoscopo(R.drawable.libra,R.string.Horoscopo_name_Libra),
        Horoscopo(R.drawable.piscis,R.string.Horoscopo_name_Piscis),
        Horoscopo(R.drawable.acuario,R.string.Horoscopo_name_Acuario),
        Horoscopo(R.drawable.geminis,R.string.Horoscopo_name_Geminis)

    )

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        inicializar()
    }

    fun inicializar(){

        val adapter :HoroscopoAdapter = HoroscopoAdapter(listaDeHoroscopos,{
            onItemClickListener(it)
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        //val horoscopo: Horoscopo(aries:int,aries:int)

    }

private fun onItemClickListener(position:Int){


    Toast.makeText(this,getString(listaDeHoroscopos[position].name),Toast.LENGTH_LONG).show()
}


}





