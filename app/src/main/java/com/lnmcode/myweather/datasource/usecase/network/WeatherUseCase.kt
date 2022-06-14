package com.lnmcode.myweather.datasource.usecase.network

import androidx.annotation.WorkerThread
import com.lnmcode.myweather.domain.model.weather.Weather
import kotlinx.coroutines.flow.Flow

// Use case may be return WeatherState, to manage state of value
// state includes of data, message, status
interface WeatherUseCase {
    @WorkerThread
    suspend fun getWeatherById(id: String, onSuccess: () -> Unit): Flow<Weather>

    @WorkerThread
    suspend fun getWeatherByLatLon(lat: String, lon: String, onSuccess: () -> Unit): Flow<Weather>
}