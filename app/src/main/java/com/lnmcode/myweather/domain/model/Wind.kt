package com.lnmcode.myweather.domain.model

import com.lnmcode.myweather.datasource.cache.entities.weather.WindEntity
import com.lnmcode.myweather.mapper.EntityMapper

data class Wind(
    val deg: Int? = null,
    val speed: Double? = null,
    val gust: Double? = null
) : EntityMapper<WindEntity> {
    override fun toEntity() = WindEntity(
        deg = deg,
        speed = speed,
        gust = gust,
    )
}