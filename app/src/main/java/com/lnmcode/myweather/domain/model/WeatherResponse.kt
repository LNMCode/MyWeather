package com.lnmcode.myweather.domain.model

import com.lnmcode.myweather.datasource.network.model.Clouds
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class WeatherResponse(
	val rain: Rain? = null,
	val visibility: Int? = null,
	val timezone: Int? = null,
	val main: Main? = null,
	val clouds: Clouds? = null,
	val sys: Sys? = null,
	val dt: Int? = null,
	val coord: Coord? = null,
	val weather: List<WeatherItem?>? = null,
	val name: String? = null,
	val cod: Int? = null,
	val id: Int? = null,
	val base: String? = null,
	val wind: Wind? = null
)







