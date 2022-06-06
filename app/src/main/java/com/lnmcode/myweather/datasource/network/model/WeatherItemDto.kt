package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.mapper.DomainMapper
import com.lnmcode.myweather.domain.model.weather.WeatherItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherItemDto (

    @field:Json(name="icon")
    val icon: String? = null,

    @field:Json(name="description")
    val description: String? = null,

    @field:Json(name="main")
    val main: String? = null,

    @field:Json(name="id")
    val id: Int? = null
): DomainMapper<WeatherItem> {
    override fun toDomain() = WeatherItem(
        icon = icon,
        description = description,
        main = main,
        id = id,
    )
}
