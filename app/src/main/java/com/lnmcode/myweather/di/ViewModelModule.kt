package com.lnmcode.myweather.di

import com.lnmcode.myweather.presentation.ui.home.HomeViewModel
import com.lnmcode.myweather.presentation.ui.home_weather.HomeWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get(), get()) }

    viewModel { HomeWeatherViewModel(get(), get()) }
}