package com.lnmcode.myweather.domain.model.list_location

import com.lnmcode.myweather.datasource.cache.entities.list_location.ListLocationEntity
import com.lnmcode.myweather.mapper.EntityMapper

data class ListLocation(
    val lat: Double? = null,
    val lon: Double? = null,
    val isCurrentLocation: Boolean = true,
): EntityMapper<ListLocationEntity> {
    override fun toEntity() = ListLocationEntity(
        lat = lat,
        lon = lon,
        isCurrentLocation = isCurrentLocation,
    )
}