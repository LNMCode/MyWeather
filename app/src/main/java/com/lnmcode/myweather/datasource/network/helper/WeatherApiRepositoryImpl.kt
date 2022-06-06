package com.lnmcode.myweather.datasource.network.helper

import com.lnmcode.myweather.datasource.network.model.WeatherResponse
import com.lnmcode.myweather.domain.model.weather.Weather
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherApiRepositoryImpl(
    private val apiService: ApiService,
    private val ioDispatcher: CoroutineDispatcher,
) : WeatherApiRepository {
    override suspend fun getWeatherById(
        id: String
    ): WeatherResponse {
        return withContext(ioDispatcher) {
            apiService.getWeatherById(id = id)
        }
    }

    override suspend fun getWeatherByLatLon(
        lat: String,
        lon: String,
    ): WeatherResponse = withContext(Dispatchers.IO) {
        return@withContext apiService.getWeatherByLatLon(lat = lat, lon = lon)
    }

}