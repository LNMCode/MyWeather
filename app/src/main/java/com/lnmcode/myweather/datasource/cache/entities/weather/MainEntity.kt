package com.lnmcode.myweather.datasource.cache.entities.weather


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lnmcode.myweather.domain.model.Main
import com.lnmcode.myweather.mapper.DomainMapper
import com.squareup.moshi.Json

data class MainEntity(
    @ColumnInfo(name = "feels_like")
    val feelsLike: Double?,

    @ColumnInfo(name = "humidity")
    val humidity: Int?,

    @ColumnInfo(name = "pressure")
    val pressure: Int?,

    @ColumnInfo(name = "temp")
    val temp: Double?,

    @ColumnInfo(name = "temp_max")
    val tempMax: Double?,

    @ColumnInfo(name = "temp_min")
    val tempMin: Double?,

    @ColumnInfo(name = "grnd_level")
    val grndLevel: Int? = null,

    @ColumnInfo(name = "sea_level")
    val seaLevel: Int? = null,
) : DomainMapper<Main> {
    override fun toDomain() = Main(
        temp = temp,
        tempMin = tempMin,
        grndLevel = grndLevel,
        humidity = humidity,
        pressure = pressure,
        seaLevel = seaLevel,
        feelsLike = feelsLike,
        tempMax = tempMax,
    )
}