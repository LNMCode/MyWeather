package com.lnmcode.myweather.datasource.helper.network

import com.lnmcode.myweather.datasource.network.ApiService
import com.lnmcode.myweather.datasource.network.model.WeatherResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherApiRepositoryImpl(
    private val apiService: ApiService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
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
    ): WeatherResponse = withContext(ioDispatcher) {
        return@withContext apiService.getWeatherByLatLon(lat = lat, lon = lon)
    }

}