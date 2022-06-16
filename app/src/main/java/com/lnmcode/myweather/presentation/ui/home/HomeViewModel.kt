package com.lnmcode.myweather.presentation.ui.home

import androidx.lifecycle.viewModelScope
import com.lnmcode.myweather.datasource.usecase.cache.ListLocationUseCase
import com.lnmcode.myweather.datasource.usecase.network.WeatherUseCase
import com.lnmcode.myweather.domain.model.list_location.ListLocation
import com.lnmcode.myweather.domain.model.weather.Weather
import com.lnmcode.myweather.presentation.base.BaseViewModel
import com.lnmcode.myweather.presentation.ui.home.HomeEvents.GetAllLocation
import com.lnmcode.myweather.presentation.ui.home.HomeEvents.InsertLocation
import com.lnmcode.myweather.presentation.ui.home_weather.HomeWeatherEvents
import com.lnmcode.myweather.presentation.ui.home_weather.LocationTrigger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(
    private val weatherUseCase: WeatherUseCase,
    private val listLocationUseCase: ListLocationUseCase,
) : BaseViewModel() {

    private val _resultInsertLocation = MutableStateFlow(-1)
    val resultInsertLocation: StateFlow<Int> = _resultInsertLocation

    private val _listLocation = MutableStateFlow(listOf<ListLocation>())
    val listLocation = _listLocation

    fun onTriggerEvents(event: HomeEvents) {
        when (event) {
            is InsertLocation -> {
                insertLocation(event.locationTrigger)
            }
            is GetAllLocation -> {
                getAllLocation()
            }
        }
    }

    private fun insertLocation(locationTrigger: LocationTrigger) {
        requestEvent {
            val listLocation = ListLocation(lat = locationTrigger.lat, lon = locationTrigger.lon)
            listLocationUseCase.insertLocation(
                listLocation = listLocation
            ) {
                setLoading(false)
            }.collectLatest { result ->
                Timber.d(result.toString())
                _resultInsertLocation.value = result.toInt()
            }
        }
    }

    private fun getAllLocation() {
        requestEvent {
            listLocationUseCase.getAllLocations {
                setLoading(false)
            }.collectLatest { list ->
                _listLocation.value = list
            }
        }
    }
}