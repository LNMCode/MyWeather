package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.mapper.DomainMapper
import com.lnmcode.myweather.domain.model.Weather
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    @field:Json(name="rain")
	val rain: RainDto? = null,

    @field:Json(name="visibility")
	val visibility: Int? = null,

    @field:Json(name="timezone")
	val timezone: Int? = null,

    @field:Json(name="main")
	val main: MainDto ? = null,

    @field:Json(name="clouds")
	val clouds: CloudsDto ? = null,

    @field:Json(name="sys")
	val sys: SysDto ? = null,

    @field:Json(name="dt")
	val dt: Int? = null,

    @field:Json(name="coord")
	val coord: CoordDto ? = null,

    @field:Json(name="weather")
	val weather: List<WeatherItemDto?>? = null,

    @field:Json(name="name")
	val name: String? = null,

    @field:Json(name="cod")
	val cod: Int? = null,

    @field:Json(name="id")
	val id: Int? = null,

    @field:Json(name="base")
	val base: String? = null,

    @field:Json(name="wind")
	val wind: WindDto ? = null
): DomainMapper<Weather> {
    override fun toDomain() = Weather(
        rain = rain?.toDomain(),
        visibility = visibility,
        timezone = timezone,
        main = main?.toDomain(),
        clouds = clouds?.toDomain(),
        sys = sys?.toDomain(),
        dt = dt,
        coord = coord?.toDomain(),
        weather = weather?.map { it?.toDomain() },
        name = name,
        cod = cod,
        id = id,
        base = base,
        wind = wind?.toDomain(),
    )
}







