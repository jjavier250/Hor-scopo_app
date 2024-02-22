package com.example.horoscopo_app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo_app.R
import com.example.horoscopo_app.adapters.HoroscopoAdapter
import com.example.horoscopo_app.data.Horoscopo
import com.example.horoscopo_app.data.HoroscopoLista
import com.example.horoscopo_app.data.HoroscopoProvider


class MainActivity : AppCompatActivity() {


    var listaDeHoroscopos = HoroscopoLista().cargarLista()


/*
    val listaDeHoroscopos = listOf(
        Horoscopo(R.drawable.aries, R.string.Horoscopo_name_Aries,R.string.Horoscopo_fechas_Aries.toString()),
        Horoscopo(R.drawable.tauro, R.string.Horoscopo_name_Tauro,R.string.Horoscopo_fechas_Tauro.toString()),
        Horoscopo(R.drawable.sagitario, R.string.Horoscopo_name_Sagitario,R.string.Horoscopo_fechas_Sagitario.toString()),
        Horoscopo(R.drawable.cancer,R.string.Horoscopo_name_Cancer,R.string.Horoscopo_fechas_Cancer.toString()),
        Horoscopo(R.drawable.escorpio,R.string.Horoscopo_name_Escorpio,R.string.Horoscopo_fechas_Escorpio.toString()),
        Horoscopo(R.drawable.leo,R.string.Horoscopo_name_Leo,R.string.Horoscopo_fechas_Leo.toString()),
        Horoscopo(R.drawable.libra,R.string.Horoscopo_name_Libra,R.string.Horoscopo_fechas_Libra.toString()),
        Horoscopo(R.drawable.piscis,R.string.Horoscopo_name_Piscis,R.string.Horoscopo_fechas_Piscis.toString()),
        Horoscopo(R.drawable.acuario,R.string.Horoscopo_name_Acuario,R.string.Horoscopo_fechas_Acuario.toString()),
        Horoscopo(R.drawable.geminis,R.string.Horoscopo_name_Geminis,R.string.Horoscopo_fechas_Geminis.toString()),
        Horoscopo(R.drawable.capricornio,R.string.Horoscopo_name_Capricornio,R.string.Horoscopo_fechas_Capricornio.toString()),
        Horoscopo(R.drawable.virgo,R.string.Horoscopo_name_Virgo,R.string.Horoscopo_fechas_Virgo.toString())

    )
*/
    lateinit var recyclerView: RecyclerView

    lateinit var adapter:HoroscopoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        inicializar()
    }

    fun inicializar(){



        adapter = HoroscopoAdapter(listaDeHoroscopos,{ llamarPantalla(it) })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        //val horoscopo: Horoscopo(aries:int,aries:int)

    }

private fun llamarPantalla(position:Int){

        //pop up con el horoscopo selecionado
    Toast.makeText(this,getString(listaDeHoroscopos[position].name),Toast.LENGTH_LONG).show()

   val intent = Intent(this, detalleHoroscopo::class.java)
    intent.putExtra("NOMBRE_HOROSCOPO",getString(listaDeHoroscopos[position].name))
    intent.putExtra("IMAGEN_HOROSCOPO",listaDeHoroscopos[position].image)
    startActivity(intent)

}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)

        initSearchView(menu?.findItem(R.id.menu_buscar))

        return true
    }


    private fun initSearchView(searchItem: MenuItem?) {
        if (searchItem != null) {
            var searchView = searchItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    if (query.isNullOrEmpty()) {
                        listaDeHoroscopos = HoroscopoLista().cargarLista()
                    } else {
                        listaDeHoroscopos = HoroscopoLista().cargarLista()
                            .filter { getString(it.name).contains(query, true) }
                    }
                    adapter.updateData(listaDeHoroscopos)
                    return true
                }
            })
        }
    }
}







