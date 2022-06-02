package com.lnmcode.myweather.datasource.cache.entities

import androidx.room.*
import com.lnmcode.myweather.datasource.cache.entities.holder.WeatherItemEntityHolder

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "base")
    val base: String,

    @Embedded(prefix = "clouds_")
    val cloudsEntity: CloudsEntity,

    @ColumnInfo(name = "cod")
    val cod: Int,

    @Embedded(prefix = "coord_")
    val coordEntity: CoordEntity,

    @ColumnInfo(name = "dt")
    val dt: Int,

    @Embedded(prefix = "main_")
    val mainEntity: MainEntity,

    @ColumnInfo(name = "name")
    val name: String,

    @Embedded(prefix = "sys_")
    val sysEntity: SysEntity,

    @ColumnInfo(name = "timezone")
    val timezone: Int,

    @ColumnInfo(name = "visibility")
    val visibility: Int,

    val weatherItemEntity: WeatherItemEntityHolder,

    @Embedded(prefix = "wind_")
    val windEntity: WindEntity
)