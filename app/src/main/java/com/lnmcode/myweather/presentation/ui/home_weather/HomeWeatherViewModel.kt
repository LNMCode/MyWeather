package com.lnmcode.myweather.presentation.ui.home_weather

import androidx.lifecycle.viewModelScope
import com.lnmcode.myweather.datasource.usecase.cache.ListLocationUseCase
import com.lnmcode.myweather.datasource.usecase.network.WeatherUseCase
import com.lnmcode.myweather.domain.model.list_location.ListLocation
import com.lnmcode.myweather.domain.model.weather.Weather
import com.lnmcode.myweather.presentation.base.BaseViewModel
import com.lnmcode.myweather.presentation.ui.home_weather.HomeWeatherEvents.GetListLocation
import com.lnmcode.myweather.presentation.ui.home_weather.HomeWeatherEvents.LoadWeather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeWeatherViewModel(
    private val weatherUseCase: WeatherUseCase,
    private val listLocationUseCase: ListLocationUseCase,
) : BaseViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _isLoading

    private val _weather = MutableStateFlow(null as Weather?)
    val weather: StateFlow<Weather?> = _weather

    private val _listLocation = MutableStateFlow(listOf<ListLocation>())
    val listLocation: StateFlow<List<ListLocation>> = _listLocation

    fun onTriggerEvents(event: HomeWeatherEvents) {
        when (event) {
            is LoadWeather -> {
                loadWeather(event.locationTrigger)
            }
            is GetListLocation -> {
                getListLocation()
            }
        }
    }

    private fun loadWeather(locationTrigger: LocationTrigger) {
        _isLoading.value = true
        viewModelScope.launch {
            weatherUseCase.getWeatherByLatLon(
                lat = locationTrigger.lat.toString(),
                lon = locationTrigger.lon.toString()
            ) {
                _isLoading.value = false
            }.collectLatest { weather ->
                Timber.d(weather.name)
                _weather.value = weather
            }
        }
    }

    private fun getListLocation() {
        _isLoading.value = true
        viewModelScope.launch {
            listLocationUseCase.getAllLocations {
                _isLoading.value = false
            }.collectLatest { list ->
                Timber.d(list.size.toString())
                _listLocation.value = list
            }
        }
    }

}