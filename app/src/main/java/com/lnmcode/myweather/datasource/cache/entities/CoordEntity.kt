package com.lnmcode.myweather.datasource.cache.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class CoordEntity(
    @ColumnInfo(name ="lat")
    val lat: Int,

    @ColumnInfo(name ="lon")
    val lon: Int
)