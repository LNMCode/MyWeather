package com.lnmcode.myweather.datasource.network.helper

import com.lnmcode.myweather.datasource.network.model.WeatherResponse

interface WeatherApiRepository {
    suspend fun getWeatherById(id: String) : WeatherResponse

    suspend fun getWeatherByLatLon(lat: String, lon: String): WeatherResponse
}