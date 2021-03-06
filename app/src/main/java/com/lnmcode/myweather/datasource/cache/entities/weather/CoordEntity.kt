package com.lnmcode.myweather.datasource.cache.entities.weather


import androidx.room.ColumnInfo
import com.lnmcode.myweather.domain.model.weather.Coord
import com.lnmcode.myweather.mapper.DomainMapper

data class CoordEntity(
    @ColumnInfo(name ="lat")
    val lat: Double? = null,

    @ColumnInfo(name ="lon")
    val lon: Double? = null
): DomainMapper<Coord> {
    override fun toDomain() = Coord(
        lon = lon,
        lat = lat,
    )
}