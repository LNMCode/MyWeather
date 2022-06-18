package com.lnmcode.myweather.domain.model.list_location

import com.lnmcode.myweather.datasource.cache.entities.list_location.ListLocationEntity
import com.lnmcode.myweather.mapper.EntityMapper

data class ListLocation(
    val id: Int? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    val order: Int = 0,
    val isCurrentLocation: Boolean = true,
): EntityMapper<ListLocationEntity> {
    override fun toEntity() = ListLocationEntity(
        id = id,
        lat = lat,
        lon = lon,
        order = order,
        isCurrentLocation = isCurrentLocation,
    )
}