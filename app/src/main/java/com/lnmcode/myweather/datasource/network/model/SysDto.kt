package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.mapper.DomainMapper
import com.lnmcode.myweather.domain.model.Sys
import com.squareup.moshi.Json

data class SysDto (
    @Json(name="country")
    val country: String? = null,

    @Json(name="sunrise")
    val sunrise: Int? = null,

    @Json(name="sunset")
    val sunset: Int? = null
): DomainMapper<Sys> {
    override fun toDomain() = Sys(
        country = country,
        sunrise = sunrise,
        sunset = sunset,
    )
}