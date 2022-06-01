package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.datasource.network.model.Clouds
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    @Json(name="rain")
	val rain: Rain? = null,

    @Json(name="visibility")
	val visibility: Int? = null,

    @Json(name="timezone")
	val timezone: Int? = null,

    @Json(name="main")
	val main: Main? = null,

    @Json(name="clouds")
	val clouds: Clouds? = null,

    @Json(name="sys")
	val sys: Sys? = null,

    @Json(name="dt")
	val dt: Int? = null,

    @Json(name="coord")
	val coord: Coord? = null,

    @Json(name="weather")
	val weather: List<WeatherItem?>? = null,

    @Json(name="name")
	val name: String? = null,

    @Json(name="cod")
	val cod: Int? = null,

    @Json(name="id")
	val id: Int? = null,

    @Json(name="base")
	val base: String? = null,

    @Json(name="wind")
	val wind: Wind? = null
)







