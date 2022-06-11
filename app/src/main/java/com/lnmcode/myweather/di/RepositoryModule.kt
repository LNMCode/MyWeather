package com.lnmcode.myweather.di

import com.lnmcode.myweather.datasource.helper.cache.ListLocationRepository
import com.lnmcode.myweather.datasource.helper.cache.ListLocationRepositoryImpl
import com.lnmcode.myweather.datasource.helper.network.WeatherApiRepository
import com.lnmcode.myweather.datasource.helper.network.WeatherApiRepositoryImpl
import com.lnmcode.myweather.domain.model.list_location.ListLocation
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {
    single<WeatherApiRepository> { WeatherApiRepositoryImpl(get()) }

    single<ListLocationRepository> { ListLocationRepositoryImpl(get()) }
}