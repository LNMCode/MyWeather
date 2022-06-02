package com.lnmcode.myweather.di

import com.lnmcode.myweather.datasource.usecase.WeatherUseCase
import com.lnmcode.myweather.datasource.usecase.WeatherUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<WeatherUseCase> { WeatherUseCaseImpl(get()) }
}