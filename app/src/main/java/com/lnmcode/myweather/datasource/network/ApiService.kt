package com.lnmcode.myweather.datasource.network

import com.lnmcode.myweather.datasource.network.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    suspend fun getWeatherById(
        @Query("id") id: String,
    ): WeatherResponse

    @GET("weather")
    suspend fun getWeatherByLatLon(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
    ): WeatherResponse
}