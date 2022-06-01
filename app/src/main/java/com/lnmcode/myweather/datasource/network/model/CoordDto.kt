package com.lnmcode.myweather.datasource.network.model

import com.squareup.moshi.Json

data class CoordDto (
    @Json(name="lon")
    val lon: Double? = null,

    @Json(name="lat")
    val lat: Double? = null
)
