package com.lnmcode.myweather.domain.model

import com.lnmcode.myweather.datasource.cache.entities.CloudsEntity
import com.lnmcode.myweather.mapper.EntityMapper

data class Clouds(
    val all: Int? = null
): EntityMapper<CloudsEntity> {
    override fun toEntity() = CloudsEntity(
        all = all
    )
}
