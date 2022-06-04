package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.mapper.DomainMapper
import com.lnmcode.myweather.domain.model.Sys
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SysDto (
    @field:Json(name="country")
    val country: String? = null,

    @field:Json(name="sunrise")
    val sunrise: Int? = null,

    @field:Json(name="sunset")
    val sunset: Int? = null,

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "type")
    val type: Int? = null
): DomainMapper<Sys> {
    override fun toDomain() = Sys(
        country = country,
        sunrise = sunrise,
        sunset = sunset,
        id = id,
        type = type
    )
}