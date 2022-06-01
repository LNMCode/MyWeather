package com.lnmcode.myweather.datasource.network.model

import com.squareup.moshi.Json

data class CloudsDto (
    @Json(name="all")
    val all: Int? = null
)
