package com.lnmcode.myweather.datasource.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    @Json(name="rain")
	val rain: RainDto ? = null,

    @Json(name="visibility")
	val visibility: Int? = null,

    @Json(name="timezone")
	val timezone: Int? = null,

    @Json(name="main")
	val main: MainDto ? = null,

    @Json(name="clouds")
	val clouds: CloudsDto ? = null,

    @Json(name="sys")
	val sys: SysDto ? = null,

    @Json(name="dt")
	val dt: Int? = null,

    @Json(name="coord")
	val coord: CoordDto ? = null,

    @Json(name="weather")
	val weather: List<WeatherItemDto ?>? = null,

    @Json(name="name")
	val name: String? = null,

    @Json(name="cod")
	val cod: Int? = null,

    @Json(name="id")
	val id: Int? = null,

    @Json(name="base")
	val base: String? = null,

    @Json(name="wind")
	val wind: WindDto ? = null
)







