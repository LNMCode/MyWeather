package com.lnmcode.myweather.datasource.network.model

import com.squareup.moshi.Json

data class Coord(
    @Json(name="lon")
    val lon: Double? = null,

    @Json(name="lat")
    val lat: Double? = null
)
