package com.lnmcode.myweather.presentation.ui.home

import com.lnmcode.myweather.presentation.ui.home_weather.LocationTrigger

sealed class HomeEvents {

    data class InsertLocation(val locationTrigger: LocationTrigger): HomeEvents()

}