package com.lnmcode.myweather.presentation.ui.home_weather

import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.lnmcode.myweather.R

enum class HomeWeatherStateWeather(
    val value: String,
    @ColorInt val colorItem: Int,
    @DrawableRes val background: Int,
) {
    CLEAR_SKY("Clear", R.color.clear_sky, R.drawable.clear),
    FEW_CLOUDS("Clouds", R.color.few_clouds, R.drawable.clouds),
    SCATTERED_CLOUDS("scattered clouds", R.color.scattered_clouds, R.drawable.icon_weather_temp),
    BROKEN_CLOUDS("broken clouds", R.color.broken_clouds, R.drawable.icon_weather_temp),
    SHOWER_RAIN("shower rain", R.color.shower_rain, R.drawable.icon_weather_temp),
    RAIN("Rain", R.color.rain, R.drawable.rain),
    THUNDERSTORM("Thunderstorm", R.color.thunderstorm, R.drawable.icon_weather_temp),
    SNOW("Snow", R.color.snow, R.drawable.snow),
    MIST("Mist", R.color.mist, R.drawable.mist),
}