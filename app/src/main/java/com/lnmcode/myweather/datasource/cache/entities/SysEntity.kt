package com.lnmcode.myweather.datasource.cache.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class SysEntity(
    @ColumnInfo(name = "country")
    val country: String,

    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "sunrise")
    val sunrise: Int,

    @ColumnInfo(name = "sunset")
    val sunset: Int,

    @ColumnInfo(name = "type")
    val type: Int
)