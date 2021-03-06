package com.lnmcode.myweather.datasource.cache.entities.weather


import androidx.room.ColumnInfo
import com.lnmcode.myweather.domain.model.weather.WeatherItem
import com.lnmcode.myweather.mapper.DomainMapper

data class WeatherItemEntity(
    @ColumnInfo(name = "description")
    val description: String? = null,

    @ColumnInfo(name = "icon")
    val icon: String? = null,

    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "main")
    val main: String? = null
) : DomainMapper<WeatherItem> {
    override fun toDomain() = WeatherItem(
        icon = icon,
        description = description,
        main = main,
        id = id,
    )
}
