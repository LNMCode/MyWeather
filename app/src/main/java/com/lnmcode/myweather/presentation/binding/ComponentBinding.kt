package com.lnmcode.myweather.presentation.binding

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.databinding.BindingAdapter
import com.google.android.material.card.MaterialCardView
import com.lnmcode.myweather.presentation.ui.home_weather.HomeWeatherStateWeather

object ComponentBinding {
    @JvmStatic
    @BindingAdapter("loadBackgroundWeatherState")
    fun bindBackgroundViewGroup(view: NestedScrollView, state: String?) {
        setBackgroundByState(state) {
            view.setBackgroundResource(it.background)
        }
    }

    @JvmStatic
    @BindingAdapter("loadBackgroundItemWeather")
    fun bindBackgroundItemWeather(view: MaterialCardView, state: String?) {
        setBackgroundByState(state) {
            view.setCardBackgroundColor(it.colorItem)
        }
    }

    private fun setBackgroundByState(state: String?, action: (HomeWeatherStateWeather) -> Unit) {
        state?.let {
            val stateWeather =
                HomeWeatherStateWeather.values().toList().findLast { it.value == state }
            stateWeather?.let { action(it) }
        }
    }
}
