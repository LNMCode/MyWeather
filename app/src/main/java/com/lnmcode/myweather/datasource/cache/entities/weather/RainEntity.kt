package com.lnmcode.myweather.datasource.cache.entities.weather

import androidx.room.ColumnInfo
import com.lnmcode.myweather.domain.model.weather.Rain
import com.lnmcode.myweather.mapper.DomainMapper

data class RainEntity(
    @ColumnInfo(name = "1h")
    val jsonMember1h: Double? = null
) : DomainMapper<Rain> {
    override fun toDomain() = Rain(
        jsonMember1h = jsonMember1h
    )
}