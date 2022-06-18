package com.lnmcode.myweather.presentation.ui.home

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lnmcode.myweather.datasource.usecase.cache.ListLocationUseCase
import com.lnmcode.myweather.datasource.usecase.network.WeatherUseCase
import com.lnmcode.myweather.domain.model.list_location.ListLocation
import com.lnmcode.myweather.domain.model.weather.Weather
import com.lnmcode.myweather.presentation.base.BaseViewModel
import com.lnmcode.myweather.presentation.ui.home.HomeEvents.*
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

    private val _numberItemCount = MutableLiveData<Int>()
    val numberItemCount: LiveData<Int> = _numberItemCount

    init {
        onTriggerEvents(GetAllLocation)
    }

    fun onTriggerEvents(event: HomeEvents) {
        when (event) {
            is InsertLocation -> {
                insertLocation(event.locationTrigger, event.order, event.isCurrentLocation)
            }
            is GetAllLocation -> {
                getAllLocation()
            }
            is InsertOrUpdateCurrentLocation -> {
                insertOrUpdateCurrentLocation(event.locationTrigger)
            }
        }
    }

    private fun insertLocation(
        locationTrigger: LocationTrigger,
        order: Int,
        isCurrentLocation: Boolean
    ) {
        requestEvent {
            val listLocation = ListLocation(
                lat = locationTrigger.lat,
                lon = locationTrigger.lon,
                order = order,
                isCurrentLocation = isCurrentLocation
            )
            listLocationUseCase.insertLocation(
                listLocation = listLocation
            ) {
                setLoading(false)
            }.collectLatest { result ->
                Timber.d(result.toString())
                _resultInsertLocation.value = result.toInt()
                onTriggerEvents(GetAllLocation)
            }
        }
    }

    private fun getAllLocation() {
        requestEvent {
            listLocationUseCase.getAllLocations {
                setLoading(false)
            }.collectLatest { list ->
                if (list.isEmpty()) {
                    onTriggerEvents(
                        InsertLocation(
                            LocationTrigger(),
                            order = 1,
                            isCurrentLocation = false
                        )
                    )
                }
                _listLocation.value = list
                _numberItemCount.value = list.size
            }
        }
    }

    private fun insertOrUpdateCurrentLocation(locationTrigger: LocationTrigger) {
        requestEvent {
            val listLocation = ListLocation(
                lat = locationTrigger.lat,
                lon = locationTrigger.lon,
                isCurrentLocation = true
            )
            listLocationUseCase.insertOrUpdateLocation(
                listLocation = listLocation
            ) {
                setLoading(false)
            }.collectLatest { result ->
                Timber.d(result.toString())
                onTriggerEvents(GetAllLocation)
            }
        }
    }
}