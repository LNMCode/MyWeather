package com.lnmcode.myweather.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import com.google.android.gms.location.*
import com.lnmcode.myweather.presentation.ui.home_weather.LocationTrigger
import timber.log.Timber

object LocationUtils {

    fun createLocationCallback(
        callback: (LocationTrigger) -> Unit,
    ) = object : LocationCallback() {
        override fun onLocationResult(location: LocationResult) {
            super.onLocationResult(location)
            val lat = location.lastLocation.latitude
            val lon = location.lastLocation.longitude
            Timber.d("Last location : $lat, $lon")
            val locationTrigger = LocationTrigger(lat, lon)
            callback(locationTrigger)
        }
    }

    fun createLocationRequest(
        interval: Long = 4000,
        fastestInterval: Long = 2000,
        priority: Int = LocationRequest.PRIORITY_HIGH_ACCURACY
    ) = LocationRequest.create()
        .setInterval(interval)
        .setFastestInterval(fastestInterval)
        .setPriority(priority)

    fun getFusedLocationProvider(context: Context): FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    fun startLocationServiceProvider(
        fusedLocationServices: FusedLocationProviderClient,
        locationRequest: LocationRequest,
        locationCallback: LocationCallback,
    ) {
        fusedLocationServices.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    fun removeLocationServiceProvider(
        context: Context,
        locationCallback: LocationCallback
    ) {
        LocationServices.getFusedLocationProviderClient(context)
            .removeLocationUpdates(locationCallback)
    }

}