package com.example.horoscopo_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo_app.R
import com.example.horoscopo_app.data.Horoscopo

//  *********************************************** ADAPTER  ********************************************************
class HoroscopoAdapter(private val dataSet: List<Horoscopo> =listOf(), val onClickListener:(Int)->Unit) :
    RecyclerView.Adapter<HoroscopoAdapter.MiViewHolder>() {

    class MiViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.txthorocopo)  // hace referencia el textview que esta en item_horoscopo
            imageView = view.findViewById(R.id.imagehoroscopo)  // hace referencia el textview que esta en item_horoscopo
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MiViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_horoscopo, viewGroup, false) // item_horoscopo hace referencia al xml de item_horoscopo.xml

        return MiViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MiViewHolder, position: Int) {

        viewHolder.itemView.setOnClickListener{onClickListener(position)} // capturamos el click del control

        val horoscopo:Horoscopo = dataSet[position]

        val nombre = viewHolder.textView.context.getString(horoscopo.name)
        val drawable = viewHolder.textView.context.getDrawable(horoscopo.image)

        // a mi variable viewHolder le asigno al xml de la imagen y del text los valores
        viewHolder.textView.text = nombre
        viewHolder.imageView.setImageDrawable(drawable)

    }


    override fun getItemCount() = dataSet.size

}