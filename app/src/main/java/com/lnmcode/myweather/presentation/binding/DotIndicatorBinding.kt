package com.lnmcode.myweather.presentation.binding

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

object DotIndicatorBinding {

    @JvmStatic
    @BindingAdapter("bindDotIndicatorViewPager")
    fun bindDotIndicator(
        view: DotsIndicator,
        viewPager: ViewPager2,
    ) {
        view.attachTo(viewPager)
    }
}