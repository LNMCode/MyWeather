package com.lnmcode.myweather.datasource.cache.entities.weather


import androidx.room.ColumnInfo
import com.lnmcode.myweather.domain.model.weather.Wind
import com.lnmcode.myweather.mapper.DomainMapper

data class WindEntity(
    @ColumnInfo(name = "deg")
    val deg: Int? = null,

    @ColumnInfo(name = "gust")
    val gust: Double? = null,

    @ColumnInfo(name = "speed")
    val speed: Double? = null
): DomainMapper<Wind> {
    override fun toDomain() = Wind(
        deg = deg,
        speed = speed,
        gust = gust,
    )
}