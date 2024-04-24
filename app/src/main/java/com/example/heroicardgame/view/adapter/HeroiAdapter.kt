package com.example.heroicardgame.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.heroicardgame.R
import com.example.heroicardgame.model.Heroi
import com.example.heroicardgame.view.viewholder.HeroiViewHolder

class HeroiAdapter(var context: Context): RecyclerView.Adapter<HeroiViewHolder>() {

    lateinit var listaAdapter : List<Heroi>
    var onItemLongClick : ((Int) -> Unit)? = null
    var onItemClick : ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroiViewHolder {
        val layout = LayoutInflater.from(context)
            .inflate(R.layout.heroi_layout, parent, false)
        return HeroiViewHolder(layout)
    }

    override fun onBindViewHolder(holder: HeroiViewHolder, position: Int) {
        val heroi = listaAdapter[position]
        val txtHolder = "${heroi.nomeHeroi} - ATK:${heroi.atk} / DEF:${heroi.def}"
        holder.txtDadosHeroi.text = txtHolder

        holder.itemView.setOnLongClickListener{
            onItemLongClick?.invoke(position)
            true
        }

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(position)
        }

    }

    override fun getItemCount(): Int {
        return listaAdapter.size
    }

    fun updateAdapter(list: List<Heroi>){
        listaAdapter = list
        notifyDataSetChanged()
    }
}