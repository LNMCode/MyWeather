package com.lnmcode.myweather.domain.model.weather

import com.lnmcode.myweather.datasource.cache.entities.weather.CloudsEntity
import com.lnmcode.myweather.mapper.EntityMapper

data class Clouds(
    val all: Int? = null
): EntityMapper<CloudsEntity> {
    override fun toEntity() = CloudsEntity(
        all = all
    )
}
