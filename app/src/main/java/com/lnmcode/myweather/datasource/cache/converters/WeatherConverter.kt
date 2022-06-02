package com.lnmcode.myweather.datasource.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lnmcode.myweather.datasource.cache.entities.WeatherItemEntity

class WeatherConverter {

    @TypeConverter
    fun fromListWeatherItem(list: List<WeatherItemEntity>) = Gson().toJson(list)

    @TypeConverter
    fun fromStringWeatherItem(value: String): List<WeatherItemEntity> =
        Gson().fromJson(value, object : TypeToken<List<WeatherItemEntity>>() {}.type)
}