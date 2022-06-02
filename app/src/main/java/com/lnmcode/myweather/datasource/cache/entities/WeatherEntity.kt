package com.lnmcode.myweather.datasource.cache.entities

import androidx.room.*
import com.lnmcode.myweather.datasource.cache.converters.WeatherConverter

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "base")
    val base: String,

    @Embedded(prefix = "clouds")
    val cloudsEntity: CloudsEntity,

    @ColumnInfo(name = "cod")
    val cod: Int,

    @Embedded(prefix = "coord")
    val coordEntity: CoordEntity,

    @ColumnInfo(name = "dt")
    val dt: Int,

    @Embedded(prefix = "main")
    val mainEntity: MainEntity,

    @ColumnInfo(name = "name")
    val name: String,

    @Embedded(prefix = "sys")
    val sysEntity: SysEntity,

    @ColumnInfo(name = "timezone")
    val timezone: Int,

    @ColumnInfo(name = "visibility")
    val visibility: Int,

    @Embedded(prefix = "weather")
    val weatherItemEntity: List<WeatherItemEntity>,

    @Embedded(prefix = "wind")
    val windEntity: WindEntity
)