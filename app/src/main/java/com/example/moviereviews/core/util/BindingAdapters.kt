package com.example.moviereviews.core.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.moviereviews.R

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    Glide
        .with(this)
        .load(url)
        .placeholder(R.drawable.placeholder)
        .into(this)
}