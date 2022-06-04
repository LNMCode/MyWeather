package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.mapper.DomainMapper
import com.lnmcode.myweather.domain.model.Coord
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoordDto (
    @field:Json(name="lon")
    val lon: Double? = null,

    @field:Json(name="lat")
    val lat: Double? = null
): DomainMapper<Coord> {
    override fun toDomain() = Coord(
        lon = lon,
        lat = lat,
    )
}