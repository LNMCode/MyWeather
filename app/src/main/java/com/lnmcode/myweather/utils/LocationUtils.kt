package com.lnmcode.myweather.utils

import android.location.LocationManager
import com.lnmcode.myweather.presentation.ui.home_weather.LocationTrigger
import timber.log.Timber

object LocationUtils {

    fun locationUpdatesChanged(
        locationManager: LocationManager,
        callback: (LocationTrigger) -> Unit
    ) {
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            0,
            0f
        ) { location ->
            val lat = location.latitude
            val lon = location.longitude
            Timber.d("Last location : $lat, $lon")
            val locationTrigger = LocationTrigger(lat, lon)
            callback(locationTrigger)
        }
    }

}