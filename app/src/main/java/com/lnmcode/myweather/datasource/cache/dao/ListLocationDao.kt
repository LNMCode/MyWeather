package com.lnmcode.myweather.datasource.cache.dao

import androidx.room.*
import com.lnmcode.myweather.datasource.cache.entities.list_location.ListLocationEntity
import timber.log.Timber

@Dao
interface ListLocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(listLocationEntity: ListLocationEntity): Long

    @Query("UPDATE locations SET lat = :lat, lon = :lon WHERE is_current_location = 1")
    suspend fun updateCurrentLocation(lat: Double?, lon: Double?)

    @Query("SELECT * FROM locations")
    suspend fun getAllLocations(): List<ListLocationEntity>

    @Query("SELECT * FROM locations WHERE id = :id")
    suspend fun getLocation(id: Int): ListLocationEntity?

    @Query("SELECT * FROM locations WHERE is_current_location == 1")
    suspend fun isExistCurrentLocation(): ListLocationEntity?

    @Transaction
    suspend fun insertOrUpdateCurrentLocation(listLocationEntity: ListLocationEntity) {
        val location = isExistCurrentLocation()
        if (location == null) {
            Timber.d("Dao insert location")
            insertLocation(listLocationEntity)
        } else {
            Timber.d("Dao update location")
            updateCurrentLocation(
                lat = listLocationEntity.lat,
                lon = listLocationEntity.lon,
            )
        }
    }

}