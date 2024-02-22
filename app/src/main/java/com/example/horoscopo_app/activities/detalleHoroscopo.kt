package com.example.horoscopo_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.horoscopo_app.R
import com.example.horoscopo_app.data.Horoscopo
import com.example.horoscopo_app.data.HoroscopoLista
import com.example.horoscopo_app.data.HoroscopoProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class detalleHoroscopo : AppCompatActivity() {

    lateinit var horoscopotextview:TextView
    lateinit var horoscopoAPITextView:TextView
    lateinit var imagehoroscopo2:ImageView
    // vamos a recuperar la fecha del horoscopo de la clase horoscopo metida en HoroscopoLista
    var fehaHoroscopo:String=""
    lateinit var horoscopo:Horoscopo
    lateinit var progress:ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_horoscopo)

        //declaramos el textview
        horoscopotextview=findViewById(R.id.horoscopotextview)
        horoscopoAPITextView=findViewById(R.id.horoscopoAPITextView)
        imagehoroscopo2=findViewById(R.id.imagehoroscopo2)
        progress=findViewById(R.id.progressBar)


        //recuperamos de la pantalla anterios
        var nombre=intent.getStringExtra("NOMBRE_HOROSCOPO")
        var imagen=intent.getIntExtra("IMAGEN_HOROSCOPO", -1)

        //escribimos en el textview
        horoscopotextview.text=nombre

       // recuperamos la imagen de la pantalla anterior
        imagehoroscopo2.setImageResource(imagen)

        //Instanciamos clase y pasamos el horoscopo a buscar
        horoscopo = HoroscopoLista().cargarHoroscopo(nombre!!, this)
        //fehaHoroscopo= horoscopo.fecha.toString()
        fehaHoroscopo= getString(horoscopo.fecha)

        // BARRA DE TITULO ARRIBA

        supportActionBar?.setTitle(nombre )
        supportActionBar?.setSubtitle(fehaHoroscopo)

        //flechita para ir para atras va asociada con : +++++   para retroceder
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.apply {
        //    setDisplayHomeAsUpEnabled(true)
           //setHomeAsUpIndicator(R.drawable.escorpio) // Opcional: personaliza el icono de retroceso
      //  }

        //MENU  ESTAS LINEAS

      //  override fun onCrearmenu(menu:Menu?):Boolean{
      //      menuInflater.inflate(R.menu.main_menu.horoscopo_menu,menu)

       //     return true
      //  }
        descripcionHoroscopo()
    }

    // ++++++++++++++++++   para retroceder   ++++++++++++++++++++++++++
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Aquí maneja la acción del botón de retroceso
                finish() // Esta es una forma de retroceder la pantalla
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun descripcionHoroscopo() {

        progress.setVisibility(View.VISIBLE) // reloj de tiempo

        CoroutineScope(Dispatchers.IO).launch {
            // Llamada en segundo plano
            //Le pasaba el texto del textview ahora le vamos a pasar el id de la clase
            //val result = HoroscopoProvider().descripcionHoroscopo(horoscopotextview.text!!.toString())
            val result = HoroscopoProvider().descripcionHoroscopo(horoscopo.id)

            runOnUiThread {
                horoscopoAPITextView.text = result
                progress.setVisibility(View.GONE) // reloj de tiempo que se oculte

            }

        }

    }
}