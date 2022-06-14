package com.lnmcode.myweather.datasource.usecase.network

import com.lnmcode.myweather.datasource.helper.network.WeatherApiRepository
import com.lnmcode.myweather.domain.model.weather.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import timber.log.Timber

class WeatherUseCaseImpl(
    private val weatherApiRepository: WeatherApiRepository,
) : WeatherUseCase {
    override suspend fun getWeatherById(id: String, onSuccess: () -> Unit): Flow<Weather> = flow {
        val weather = weatherApiRepository.getWeatherById(id = id).toDomain()
        emit(weather)
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO).catch { e ->
        Timber.e(e.message)
    }

    override suspend fun getWeatherByLatLon(
        lat: String,
        lon: String,
        onSuccess: () -> Unit,
    ): Flow<Weather> = flow {
        val weather = weatherApiRepository.getWeatherByLatLon(lat, lon).toDomain()
        emit(weather)
    }.onCompletion { onSuccess() }.flowOn(Dispatchers.IO).catch { e ->
        Timber.e(e.message)
    }
}
