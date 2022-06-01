package com.lnmcode.myweather.datasource.network.model

import com.squareup.moshi.Json

data class SysDto (
    @Json(name="country")
    val country: String? = null,

    @Json(name="sunrise")
    val sunrise: Int? = null,

    @Json(name="sunset")
    val sunset: Int? = null
)