package com.identify.design.intro

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.identify.design.R
import com.identify.design.databinding.ItemIntroBinding

class IntroViewHolder(val binding: ItemIntroBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Pair<Drawable?, String>) {
        binding.imgIllustration.setImageDrawable(item.first)
        binding.tvDesc.text = item.second

    }
}