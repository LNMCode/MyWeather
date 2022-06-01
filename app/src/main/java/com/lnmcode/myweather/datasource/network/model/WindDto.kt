package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.datasource.network.DomainMapper
import com.lnmcode.myweather.domain.model.Wind
import com.squareup.moshi.Json

data class WindDto (

    @Json(name="deg")
    val deg: Int? = null,

    @Json(name="speed")
    val speed: Double? = null,

    @Json(name="gust")
    val gust: Double? = null
): DomainMapper<Wind> {
    override fun toDomain() = Wind(
        deg = deg,
        speed = speed,
        gust = gust,
    )
}