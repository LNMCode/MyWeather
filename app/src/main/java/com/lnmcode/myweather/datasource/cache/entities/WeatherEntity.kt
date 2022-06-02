package com.lnmcode.myweather.datasource.cache.entities

import androidx.room.*
import com.lnmcode.myweather.datasource.cache.entities.holder.WeatherItemEntityHolder
import com.lnmcode.myweather.domain.model.Weather
import com.lnmcode.myweather.mapper.DomainMapper

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @Embedded(prefix="rain_")
    val rainEntity: RainEntity,

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

    val weatherItemHolder: WeatherItemEntityHolder,

    @Embedded(prefix = "wind_")
    val windEntity: WindEntity
): DomainMapper<Weather> {
    override fun toDomain() = Weather(
        rain = rainEntity.toDomain(),
        visibility = visibility,
        timezone = timezone,
        main = mainEntity.toDomain(),
        clouds = cloudsEntity.toDomain(),
        sys = sysEntity.toDomain(),
        dt = dt,
        coord = coordEntity.toDomain(),
        weather = weatherItemHolder.weatherItemEntity.map { it.toDomain() },
        name = name,
        cod = cod,
        id = id,
        base = base,
        wind = windEntity.toDomain(),
    )
}