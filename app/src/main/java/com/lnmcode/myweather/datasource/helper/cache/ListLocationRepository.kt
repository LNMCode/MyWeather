package com.lnmcode.myweather.datasource.helper.cache

import com.lnmcode.myweather.datasource.cache.entities.list_location.ListLocationEntity

interface ListLocationRepository {
    suspend fun insertLocation(locationEntity: ListLocationEntity): Long

    suspend fun getAllLocations(): List<ListLocationEntity>
}