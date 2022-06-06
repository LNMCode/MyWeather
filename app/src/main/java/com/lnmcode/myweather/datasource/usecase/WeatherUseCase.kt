package com.lnmcode.myweather.datasource.usecase

import androidx.annotation.WorkerThread
import com.lnmcode.myweather.domain.model.weather.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherUseCase {
    @WorkerThread
    suspend fun getWeatherById(id: String, onSuccess: () -> Unit): Flow<Weather>

    @WorkerThread
    suspend fun getWeatherByLatLon(lat: String, lon: String, onSuccess: () -> Unit): Flow<Weather>
}