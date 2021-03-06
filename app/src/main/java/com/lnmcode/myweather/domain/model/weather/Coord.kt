package com.lnmcode.myweather.domain.model.weather

import com.lnmcode.myweather.datasource.cache.entities.weather.CoordEntity
import com.lnmcode.myweather.mapper.EntityMapper

data class Coord(
    val lon: Double? = null,
    val lat: Double? = null
): EntityMapper<CoordEntity> {
    override fun toEntity() = CoordEntity(
        lat = lat,
        lon = lon
    )
}
