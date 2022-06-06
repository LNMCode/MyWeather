package com.lnmcode.myweather.domain.model

import com.lnmcode.myweather.datasource.cache.entities.weather.MainEntity
import com.lnmcode.myweather.mapper.EntityMapper

data class Main(
    val temp: Double? = null,
    val tempMin: Double? = null,
    val grndLevel: Int? = null,
    val humidity: Int? = null,
    val pressure: Int? = null,
    val seaLevel: Int? = null,
    val feelsLike: Double? = null,
    val tempMax: Double? = null
): EntityMapper<MainEntity> {
    override fun toEntity() = MainEntity(
        temp = temp,
        tempMin = tempMin,
        grndLevel = grndLevel,
        humidity = humidity,
        pressure = pressure,
        seaLevel = seaLevel,
        feelsLike = feelsLike,
        tempMax = tempMax,
    )
}
