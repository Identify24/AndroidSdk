package com.identify.design.intro

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.identify.design.R

class IntroAdapter(val items : List<Pair<Drawable?,String>>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return IntroViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_intro,parent,false))
    }

    override fun getItemCount(): Int  = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is IntroViewHolder) holder.bind(items[position])
    }
}