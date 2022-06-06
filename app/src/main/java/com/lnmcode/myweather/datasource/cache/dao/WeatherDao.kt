package com.lnmcode.myweather.datasource.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lnmcode.myweather.datasource.cache.entities.weather.WeatherEntity

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weatherEntity: WeatherEntity): Long

    @Query("SELECT * FROM weather")
    suspend fun getWeather(): WeatherEntity
}