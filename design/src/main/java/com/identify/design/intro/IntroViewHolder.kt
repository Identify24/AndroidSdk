package com.identify.design.intro

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.identify.design.R

class IntroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Pair<Drawable?, String>) {
        val imgView = itemView.findViewById<ImageView>(R.id.imgIllustration)
        val tvDesc = itemView.findViewById<TextView>(R.id.tvDesc)
        imgView.setImageDrawable(item.first)
        tvDesc.text = item.second
    }
}