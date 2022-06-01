package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.datasource.network.DomainMapper
import com.lnmcode.myweather.domain.model.Main
import com.squareup.moshi.Json

data class MainDto (
    @Json(name="temp")
    val temp: Double? = null,

    @Json(name="temp_min")
    val tempMin: Double? = null,

    @Json(name="grnd_level")
    val grndLevel: Int? = null,

    @Json(name="humidity")
    val humidity: Int? = null,

    @Json(name="pressure")
    val pressure: Int? = null,

    @Json(name="sea_level")
    val seaLevel: Int? = null,

    @Json(name="feels_like")
    val feelsLike: Double? = null,

    @Json(name="temp_max")
    val tempMax: Double? = null
): DomainMapper<Main> {
    override fun toDomain() = Main(
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