package com.lnmcode.myweather.datasource.cache.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class WindEntity(
    @ColumnInfo(name = "deg")
    val deg: Int,

    @ColumnInfo(name = "gust")
    val gust: Double,

    @ColumnInfo(name = "speed")
    val speed: Double
)