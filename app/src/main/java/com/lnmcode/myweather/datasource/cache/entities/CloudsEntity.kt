package com.lnmcode.myweather.datasource.cache.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lnmcode.myweather.domain.model.Clouds
import com.lnmcode.myweather.mapper.DomainMapper
import com.lnmcode.myweather.mapper.EntityMapper

data class CloudsEntity(
    @ColumnInfo(name ="all")
    val all: Int
): DomainMapper<Clouds> {
    override fun toDomain() = Clouds(
        all = all,
    )
}