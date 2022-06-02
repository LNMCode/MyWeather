package com.lnmcode.myweather.datasource.cache.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class MainEntity(
    @ColumnInfo(name ="feels_like")
    val feelsLike: Double,
    @ColumnInfo(name ="humidity")
    val humidity: Int,
    @ColumnInfo(name ="pressure")
    val pressure: Int,
    @ColumnInfo(name ="temp")
    val temp: Double,
    @ColumnInfo(name ="temp_max")
    val tempMax: Double,
    @ColumnInfo(name ="temp_min")
    val tempMin: Double
)