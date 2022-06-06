package com.lnmcode.myweather.datasource.cache.entities.weather

import androidx.room.*
import com.lnmcode.myweather.datasource.cache.entities.holder.WeatherItemEntityHolder
import com.lnmcode.myweather.domain.model.Weather
import com.lnmcode.myweather.mapper.DomainMapper

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @Embedded(prefix = "rain_")
    val rainEntity: RainEntity? = null,

    @ColumnInfo(name = "base")
    val base: String? = null,

    @Embedded(prefix = "clouds_")
    val cloudsEntity: CloudsEntity? = null,

    @ColumnInfo(name = "cod")
    val cod: Int? = null,

    @Embedded(prefix = "coord_")
    val coordEntity: CoordEntity? = null,

    @ColumnInfo(name = "dt")
    val dt: Int? = null,

    @Embedded(prefix = "main_")
    val mainEntity: MainEntity? = null,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @Embedded(prefix = "sys_")
    val sysEntity: SysEntity? = null,

    @ColumnInfo(name = "timezone")
    val timezone: Int? = null,

    @ColumnInfo(name = "visibility")
    val visibility: Int? = null,

    val weatherItemHolder: WeatherItemEntityHolder? = null,

    @Embedded(prefix = "wind_")
    val windEntity: WindEntity? = null
) : DomainMapper<Weather> {
    override fun toDomain() = Weather(
        rain = rainEntity?.toDomain(),
        visibility = visibility,
        timezone = timezone,
        main = mainEntity?.toDomain(),
        clouds = cloudsEntity?.toDomain(),
        sys = sysEntity?.toDomain(),
        dt = dt,
        coord = coordEntity?.toDomain(),
        weather = weatherItemHolder?.weatherItemEntity?.map { it?.toDomain() },
        name = name,
        cod = cod,
        id = id,
        base = base,
        wind = windEntity?.toDomain(),
    )
}