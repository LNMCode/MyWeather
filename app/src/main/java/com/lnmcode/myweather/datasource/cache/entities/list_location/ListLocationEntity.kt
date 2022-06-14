package com.lnmcode.myweather.datasource.cache.entities.list_location

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lnmcode.myweather.domain.model.list_location.ListLocation
import com.lnmcode.myweather.mapper.DomainMapper

@Entity(tableName = "locations")
data class ListLocationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "lat")
    val lat: Double? = null,

    @ColumnInfo(name = "lon")
    val lon: Double? = null,

    @ColumnInfo(name = "is_current_location")
    val isCurrentLocation: Boolean = true,
) : DomainMapper<ListLocation> {
    override fun toDomain() = ListLocation(
        lat = lat,
        lon = lon,
        isCurrentLocation = isCurrentLocation,
    )

}