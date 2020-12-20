package com.foo.restaurantselection.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.foo.restaurantselection.R


fun ImageView.load(url: String, placeholder: Int = R.drawable.ic_android) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.placeholderOf(placeholder))
        .into(this)
}

fun ImageView.load(id: Int, placeholder: Int = R.drawable.ic_android) {
    Glide.with(this)
        .load(id)
        .apply(RequestOptions.placeholderOf(placeholder))
        .into(this)
}