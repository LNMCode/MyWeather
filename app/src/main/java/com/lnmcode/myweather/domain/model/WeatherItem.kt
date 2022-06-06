package com.lnmcode.myweather.domain.model

import com.lnmcode.myweather.datasource.cache.entities.weather.WeatherItemEntity
import com.lnmcode.myweather.mapper.EntityMapper

data class WeatherItem(
    val icon: String? = null,
    val description: String? = null,
    val main: String? = null,
    val id: Int? = null
) : EntityMapper<WeatherItemEntity> {
    override fun toEntity() = WeatherItemEntity(
        icon = icon,
        description = description,
        main = main,
        id = id,
    )
}