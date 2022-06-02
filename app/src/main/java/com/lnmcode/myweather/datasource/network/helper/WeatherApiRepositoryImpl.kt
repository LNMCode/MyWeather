package com.lnmcode.myweather.datasource.network.helper

import com.lnmcode.myweather.datasource.network.model.WeatherResponse

class WeatherApiRepositoryImpl(
    private val apiService: ApiService
): WeatherApiRepository {
    override suspend fun getWeatherById(id: String): WeatherResponse {
        return apiService.getWeatherById(id = id)
    }

    override suspend fun getWeatherByLatLon(lat: String, lon: String): WeatherResponse {
        return apiService.getWeatherByLatLon(lat = lat, lon = lon)
    }
}