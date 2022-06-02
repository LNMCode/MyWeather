package com.lnmcode.myweather.datasource.cache.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lnmcode.myweather.domain.model.Wind
import com.lnmcode.myweather.mapper.DomainMapper

data class WindEntity(
    @ColumnInfo(name = "deg")
    val deg: Int,

    @ColumnInfo(name = "gust")
    val gust: Double,

    @ColumnInfo(name = "speed")
    val speed: Double
): DomainMapper<Wind> {
    override fun toDomain() = Wind(
        deg = deg,
        speed = speed,
        gust = gust,
    )
}