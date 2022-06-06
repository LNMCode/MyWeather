package com.lnmcode.myweather.datasource.cache.entities.holder

import com.lnmcode.myweather.datasource.cache.entities.weather.WeatherItemEntity

data class WeatherItemEntityHolder(
    val weatherItemEntity: List<WeatherItemEntity?>?,
)