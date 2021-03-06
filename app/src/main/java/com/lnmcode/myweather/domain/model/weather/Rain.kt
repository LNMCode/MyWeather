package com.lnmcode.myweather.domain.model.weather

import com.lnmcode.myweather.datasource.cache.entities.weather.RainEntity
import com.lnmcode.myweather.mapper.EntityMapper

data class Rain(
    val jsonMember1h: Double? = null
): EntityMapper<RainEntity> {
    override fun toEntity() = RainEntity(
        jsonMember1h = jsonMember1h
    )

}