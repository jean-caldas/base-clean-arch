package com.example.baseclean.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("srcFromUrl")
fun ImageView.srcFromUrl(urlImage: String) {
    Glide.with(context).load(urlImage).into(this)
}