package com.lnmcode.myweather.datasource.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lnmcode.myweather.datasource.cache.entities.list_location.ListLocationEntity

@Dao
interface ListLocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(listLocationEntity: ListLocationEntity): Long

    @Query("SELECT * FROM locations")
    suspend fun getAllLocations(): List<ListLocationEntity>

    @Query("SELECT * FROM locations WHERE id = :id")
    suspend fun getLocation(id: Int): ListLocationEntity?

}