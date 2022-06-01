package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.datasource.network.DomainMapper
import com.lnmcode.myweather.domain.model.WeatherItem
import com.squareup.moshi.Json

data class WeatherItemDto (

    @Json(name="icon")
    val icon: String? = null,

    @Json(name="description")
    val description: String? = null,

    @Json(name="main")
    val main: String? = null,

    @Json(name="id")
    val id: Int? = null
): DomainMapper<WeatherItem> {
    override fun toDomain() = WeatherItem(
        icon = icon,
        description = description,
        main = main,
        id = id,
    )
}
