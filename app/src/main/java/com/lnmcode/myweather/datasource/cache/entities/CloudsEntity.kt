package com.lnmcode.myweather.datasource.cache.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class CloudsEntity(
    @ColumnInfo(name ="all")
    val all: Int
)