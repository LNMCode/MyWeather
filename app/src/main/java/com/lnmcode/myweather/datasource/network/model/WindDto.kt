package com.lnmcode.myweather.datasource.network.model

import com.squareup.moshi.Json

data class Wind(

    @Json(name="deg")
    val deg: Int? = null,

    @Json(name="speed")
    val speed: Double? = null,

    @Json(name="gust")
    val gust: Double? = null
)