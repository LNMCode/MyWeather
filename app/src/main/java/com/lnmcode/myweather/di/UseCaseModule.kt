package com.lnmcode.myweather.di

import com.lnmcode.myweather.datasource.usecase.cache.ListLocationUseCase
import com.lnmcode.myweather.datasource.usecase.cache.ListLocationUseCaseImpl
import com.lnmcode.myweather.datasource.usecase.network.WeatherUseCase
import com.lnmcode.myweather.datasource.usecase.network.WeatherUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<WeatherUseCase> { WeatherUseCaseImpl(get()) }

    single<ListLocationUseCase> { ListLocationUseCaseImpl(get()) }
}