package com.example.melichallenge.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.melichallenge.R
import com.example.melichallenge.model.Item

class MainAdapter (val itemList: List<Item>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>()  {

    inner class MainViewHolder (private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {          // TODO ****  listener para cada item del recyclerView ****

            itemView.setOnClickListener { v: View ->

                val position : Int = adapterPosition

                    val intent = Intent (v.context.applicationContext, ItemDetalle::class.java)


                    intent.putExtra("precio", itemList[position].price)
                    intent.putExtra("nombre", itemList[position].title)
                    intent.putExtra("imagen", itemList[position].thumbnail)

                    v.context.startActivity(intent) // todo INICIA EL ACTICITY DETALLE AL HACER TAP EN ALGUN ELEMENTO DE LA LISTA


            }

        }

        fun bindData (item: Item) {

            val price = itemView.findViewById<TextView>(R.id.tvPrecio)
            val name = itemView.findViewById<TextView>(R.id.tvNombreItem)
            val image = itemView.findViewById<ImageView>(R.id.ivItem)

            price.text = "$ "+item.price
            name.text = item.title
            image.load(item.thumbnail.replace("http://", "https://"))


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        holder.bindData(itemList[position])
    }

    override fun getItemCount(): Int {

        return itemList.size
    }

}