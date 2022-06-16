package com.lnmcode.myweather.presentation.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lnmcode.myweather.presentation.ui.home_weather.HomeWeatherFragment

class HomeSlidePagerAdapter(
    fa: Fragment,
    private val numberItemCount: Int,
) : FragmentStateAdapter(fa) {
    override fun getItemCount() = numberItemCount

    override fun createFragment(position: Int) = HomeWeatherFragment(position)
}