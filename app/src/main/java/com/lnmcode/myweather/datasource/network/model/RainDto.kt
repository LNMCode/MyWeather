package com.lnmcode.myweather.datasource.network.model

import com.squareup.moshi.Json

data class RainDto (
    @Json(name="1h")
    val jsonMember1h: Double? = null
)