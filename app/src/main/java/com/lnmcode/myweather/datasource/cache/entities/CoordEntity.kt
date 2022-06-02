package com.lnmcode.myweather.datasource.cache.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lnmcode.myweather.domain.model.Coord
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