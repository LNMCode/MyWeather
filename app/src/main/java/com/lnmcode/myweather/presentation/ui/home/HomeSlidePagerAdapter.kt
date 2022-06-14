package com.lnmcode.myweather.presentation.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lnmcode.myweather.presentation.ui.home_weather.HomeWeatherFragment

class HomeSlidePagerAdapter(
    fa: Fragment
) : FragmentStateAdapter(fa) {
    override fun getItemCount() = 5

    override fun createFragment(position: Int) = HomeWeatherFragment()
}