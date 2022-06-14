package com.lnmcode.myweather.presentation.ui.home_weather

sealed class HomeWeatherEvents {

    data class LoadWeather(val locationTrigger: LocationTrigger) : HomeWeatherEvents()

    object GetListLocation: HomeWeatherEvents()
}