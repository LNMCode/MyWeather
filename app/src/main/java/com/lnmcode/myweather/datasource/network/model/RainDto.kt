package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.datasource.network.DomainMapper
import com.lnmcode.myweather.domain.model.Rain
import com.squareup.moshi.Json

data class RainDto (
    @Json(name="1h")
    val jsonMember1h: Double? = null
): DomainMapper<Rain> {
    override fun toDomain() = Rain(
        jsonMember1h = jsonMember1h,
    )
}