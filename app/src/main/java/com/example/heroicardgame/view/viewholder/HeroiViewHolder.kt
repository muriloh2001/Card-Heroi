package com.example.heroicardgame.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heroicardgame.R

class HeroiViewHolder(layout: View): RecyclerView.ViewHolder(layout) {

    var txtDadosHeroi = layout.findViewById<TextView>(R.id.txtDadosHeroi)

}