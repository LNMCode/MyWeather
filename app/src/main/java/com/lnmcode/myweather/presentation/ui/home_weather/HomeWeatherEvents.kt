package com.lnmcode.myweather.presentation.ui.home_weather

sealed class HomeWeatherEvents {

    data class LoadWeather(val locationTrigger: LocationTrigger) : HomeWeatherEvents()

    data class GetListLocation(val position: Int): HomeWeatherEvents()
}