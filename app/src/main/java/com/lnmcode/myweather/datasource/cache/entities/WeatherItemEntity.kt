package com.lnmcode.myweather.datasource.cache.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class WeatherItemEntity(
    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "icon")
    val icon: String,

    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "main")
    val main: String
)