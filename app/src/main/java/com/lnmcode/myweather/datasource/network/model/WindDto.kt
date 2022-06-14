package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.mapper.DomainMapper
import com.lnmcode.myweather.domain.model.weather.Wind
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindDto (

    @field:Json(name="deg")
    val deg: Int? = null,

    @field:Json(name="speed")
    val speed: Double? = null,

    @field:Json(name="gust")
    val gust: Double? = null
): DomainMapper<Wind> {
    override fun toDomain() = Wind(
        deg = deg,
        speed = speed,
        gust = gust,
    )
}