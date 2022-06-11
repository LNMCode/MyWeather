package com.lnmcode.myweather.di
// for cache database

import android.content.Context
import androidx.room.Room
import com.lnmcode.myweather.datasource.cache.AppDatabase
import com.lnmcode.myweather.datasource.cache.converters.WeatherConverter
import org.koin.dsl.module

val persistenceModule = module {

    single { WeatherConverter(get()) }

    single { builderRoomDb(get(), get()) }

    // Dao
    single { get<AppDatabase>().getWeatherDao() }

    single { get<AppDatabase>().getListLocationDao() }
}

internal fun builderRoomDb(
    context: Context,
    weatherConverter: WeatherConverter,
): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        AppDatabase.DATABASE_NAME
    )
    .addTypeConverter(weatherConverter)
    .build()
