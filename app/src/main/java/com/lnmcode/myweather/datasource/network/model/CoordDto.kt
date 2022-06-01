package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.datasource.network.DomainMapper
import com.lnmcode.myweather.domain.model.Coord
import com.squareup.moshi.Json

data class CoordDto (
    @Json(name="lon")
    val lon: Double? = null,

    @Json(name="lat")
    val lat: Double? = null
): DomainMapper<Coord> {
    override fun toDomain() = Coord(
        lon = lon,
        lat = lat,
    )
}