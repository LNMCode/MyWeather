package com.lnmcode.myweather.presentation.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

object ImageViewBinding {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun bindLoadImage(view: ImageView, url: String?) {
        url?.let {
            view.load(url) {
                crossfade(true)
            }
        }
    }
}