package com.lnmcode.myweather.datasource.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lnmcode.myweather.datasource.cache.entities.holder.WeatherItemEntityHolder

class WeatherConverter {

    @TypeConverter
    fun fromWeatherItemEntityHolder(holder: WeatherItemEntityHolder): String = Gson().toJson(holder)

    @TypeConverter
    fun fromStringWeatherItemEntityHolder(value: String): WeatherItemEntityHolder =
        Gson().fromJson(value, object : TypeToken<WeatherItemEntityHolder>() {}.type)
}