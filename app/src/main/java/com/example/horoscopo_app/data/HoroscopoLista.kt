package com.example.horoscopo_app.data

import android.content.Context
import com.example.horoscopo_app.R

public class HoroscopoLista {

    fun cargarLista(): List<Horoscopo> {

        val listaDeHoroscopos = listOf(
            Horoscopo(R.drawable.aries, R.string.Horoscopo_name_Aries, R.string.Horoscopo_fechas_Aries,"Aries"),
            Horoscopo(R.drawable.tauro, R.string.Horoscopo_name_Tauro, R.string.Horoscopo_fechas_Tauro,"Taurus"),
            Horoscopo(R.drawable.sagitario, R.string.Horoscopo_name_Sagitario, R.string.Horoscopo_fechas_Sagitario,"Sagittarius"),
            Horoscopo(R.drawable.cancer, R.string.Horoscopo_name_Cancer, R.string.Horoscopo_fechas_Cancer,"Cancer"),
            Horoscopo(R.drawable.escorpio, R.string.Horoscopo_name_Escorpio, R.string.Horoscopo_fechas_Escorpio,"Scorpio"),
            Horoscopo(R.drawable.leo, R.string.Horoscopo_name_Leo, R.string.Horoscopo_fechas_Leo,"leo"),
            Horoscopo(R.drawable.libra, R.string.Horoscopo_name_Libra, R.string.Horoscopo_fechas_Libra,"Libra"),
            Horoscopo(R.drawable.piscis, R.string.Horoscopo_name_Piscis, R.string.Horoscopo_fechas_Piscis,"Pisces"),
            Horoscopo(R.drawable.acuario, R.string.Horoscopo_name_Acuario, R.string.Horoscopo_fechas_Acuario,"Aquarius"),
            Horoscopo(R.drawable.geminis, R.string.Horoscopo_name_Geminis, R.string.Horoscopo_fechas_Geminis,"Gemini"),
            Horoscopo(R.drawable.capricornio, R.string.Horoscopo_name_Capricornio, R.string.Horoscopo_fechas_Capricornio,"Capricorn"),
            Horoscopo(R.drawable.virgo, R.string.Horoscopo_name_Virgo, R.string.Horoscopo_fechas_Virgo,"Virgo")

        )

        return listaDeHoroscopos
    }

    fun cargarHoroscopo (id:String, context:Context) :Horoscopo {
        return cargarLista().find { context.getString(it.name) == id }!!
    }

}