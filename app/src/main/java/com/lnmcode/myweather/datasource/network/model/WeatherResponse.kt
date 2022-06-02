package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.mapper.DomainMapper
import com.lnmcode.myweather.domain.model.Weather
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    @Json(name="rain")
	val rain: RainDto? = null,

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
	val weather: List<WeatherItemDto?>? = null,

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







