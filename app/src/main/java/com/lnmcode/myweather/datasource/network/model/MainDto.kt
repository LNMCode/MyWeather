package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.mapper.DomainMapper
import com.lnmcode.myweather.domain.model.Main
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainDto (
    @field:Json(name="temp")
    val temp: Double? = null,

    @field:Json(name="temp_min")
    val tempMin: Double? = null,

    @field:Json(name="grnd_level")
    val grndLevel: Int? = null,

    @field:Json(name="humidity")
    val humidity: Int? = null,

    @field:Json(name="pressure")
    val pressure: Int? = null,

    @field:Json(name="sea_level")
    val seaLevel: Int? = null,

    @field:Json(name="feels_like")
    val feelsLike: Double? = null,

    @field:Json(name="temp_max")
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