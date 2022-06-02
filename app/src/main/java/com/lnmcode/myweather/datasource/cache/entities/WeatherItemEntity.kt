package com.lnmcode.myweather.datasource.cache.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lnmcode.myweather.domain.model.WeatherItem
import com.lnmcode.myweather.mapper.DomainMapper

data class WeatherItemEntity(
    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "icon")
    val icon: String,

    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "main")
    val main: String
): DomainMapper<WeatherItem> {
    override fun toDomain() = WeatherItem(
        icon = icon,
        description = description,
        main = main,
        id = id,
    )
}
