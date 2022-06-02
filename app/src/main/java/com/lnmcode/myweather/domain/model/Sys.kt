package com.lnmcode.myweather.domain.model

import com.lnmcode.myweather.datasource.cache.entities.SysEntity
import com.lnmcode.myweather.mapper.EntityMapper

data class Sys(
    val country: String? = null,
    val sunrise: Int? = null,
    val sunset: Int? = null,
    val type: Int? = null,
    val id: Int? = null,
) : EntityMapper<SysEntity> {
    override fun toEntity() = SysEntity(
        country = country,
        sunrise = sunrise,
        sunset = sunset,
        id = id,
        type = type
    )
}