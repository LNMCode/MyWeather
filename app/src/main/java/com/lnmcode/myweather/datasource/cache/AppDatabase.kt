package com.lnmcode.myweather.datasource.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lnmcode.myweather.datasource.cache.converters.WeatherConverter
import com.lnmcode.myweather.datasource.cache.dao.WeatherDao
import com.lnmcode.myweather.datasource.cache.entities.weather.WeatherEntity

@Database(entities = [WeatherEntity::class], version = 1)
@TypeConverters(value = [WeatherConverter::class])
abstract class AppDatabase: RoomDatabase() {

    abstract fun getWeatherDao() : WeatherDao

    companion object {
        val DATABASE_NAME = "app_db"
    }

}