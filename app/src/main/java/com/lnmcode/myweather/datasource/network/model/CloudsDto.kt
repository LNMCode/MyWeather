package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.datasource.network.DomainMapper
import com.lnmcode.myweather.domain.model.Clouds
import com.squareup.moshi.Json

data class CloudsDto (
    @Json(name="all")
    val all: Int? = null
): DomainMapper<Clouds> {
    override fun toDomain() = Clouds(
        all = all,
    )
}