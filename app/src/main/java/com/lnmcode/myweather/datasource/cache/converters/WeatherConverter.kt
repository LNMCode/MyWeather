package com.lnmcode.myweather.datasource.cache.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.lnmcode.myweather.datasource.cache.entities.holder.WeatherItemEntityHolder
import com.squareup.moshi.Moshi

@ProvidedTypeConverter
class WeatherConverter(private val moshi: Moshi) {

    @TypeConverter
    fun fromWeatherItemEntityHolder(holder: WeatherItemEntityHolder): String =
        moshi.adapter(WeatherItemEntityHolder::class.java).toJson(holder)

    @TypeConverter
    fun fromStringWeatherItemEntityHolder(value: String): WeatherItemEntityHolder? =
        moshi.adapter(WeatherItemEntityHolder::class.java).fromJson(value)
}