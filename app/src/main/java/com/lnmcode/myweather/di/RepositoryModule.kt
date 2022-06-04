package com.lnmcode.myweather.di

import com.lnmcode.myweather.datasource.network.helper.WeatherApiRepository
import com.lnmcode.myweather.datasource.network.helper.WeatherApiRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {
    single<WeatherApiRepository> { WeatherApiRepositoryImpl(get(), Dispatchers.IO) }
}