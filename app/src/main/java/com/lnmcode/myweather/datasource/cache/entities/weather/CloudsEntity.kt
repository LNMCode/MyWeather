package com.lnmcode.myweather.datasource.cache.entities.weather


import androidx.room.ColumnInfo
import com.lnmcode.myweather.domain.model.Clouds
import com.lnmcode.myweather.mapper.DomainMapper

data class CloudsEntity(
    @ColumnInfo(name ="all")
    val all: Int? = null
): DomainMapper<Clouds> {
    override fun toDomain() = Clouds(
        all = all,
    )
}