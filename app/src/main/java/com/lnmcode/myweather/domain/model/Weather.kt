package com.lnmcode.myweather.domain.model

import com.lnmcode.myweather.datasource.cache.entities.WeatherEntity
import com.lnmcode.myweather.datasource.cache.entities.holder.WeatherItemEntityHolder
import com.lnmcode.myweather.mapper.EntityMapper

data class Weather(
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
): EntityMapper<WeatherEntity> {
	override fun toEntity() = WeatherEntity(
		rainEntity = rain?.toEntity(),
		visibility = visibility,
		timezone = timezone,
		mainEntity = main?.toEntity(),
		cloudsEntity = clouds?.toEntity(),
		sysEntity = sys?.toEntity(),
		dt = dt,
		coordEntity = coord?.toEntity(),
		weatherItemHolder = WeatherItemEntityHolder(weather?.map { it?.toEntity() }),
		name = name,
		cod = cod,
		id = id,
		base = base,
		windEntity = wind?.toEntity(),
	)

}







