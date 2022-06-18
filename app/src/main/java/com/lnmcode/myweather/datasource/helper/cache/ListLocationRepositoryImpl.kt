package com.lnmcode.myweather.datasource.helper.cache

import com.lnmcode.myweather.datasource.cache.dao.ListLocationDao
import com.lnmcode.myweather.datasource.cache.entities.list_location.ListLocationEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListLocationRepositoryImpl(
    private val listLocationDao: ListLocationDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ListLocationRepository {
    override suspend fun insertLocation(locationEntity: ListLocationEntity): Long {
        return withContext(ioDispatcher) {
            listLocationDao . insertLocation (locationEntity)
        }
    }

    override suspend fun getAllLocations(): List<ListLocationEntity> {
        return withContext(ioDispatcher) {
            listLocationDao.getAllLocations()
        }
    }

    override suspend fun getLocation(id: Int): ListLocationEntity? {
        return withContext(ioDispatcher) {
            listLocationDao.getLocation(id)
        }
    }
}