package com.lnmcode.myweather.datasource.network.model

import com.lnmcode.myweather.mapper.DomainMapper
import com.lnmcode.myweather.domain.model.Clouds
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CloudsDto (
    @field:Json(name="all")
    val all: Int? = null
): DomainMapper<Clouds> {
    override fun toDomain() = Clouds(
        all = all,
    )
}