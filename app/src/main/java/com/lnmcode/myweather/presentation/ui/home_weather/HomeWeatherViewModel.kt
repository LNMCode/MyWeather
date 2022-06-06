package com.lnmcode.myweather.presentation.ui.home_weather

import androidx.lifecycle.viewModelScope
import com.lnmcode.myweather.datasource.usecase.WeatherUseCase
import com.lnmcode.myweather.presentation.base.BaseViewModel
import com.lnmcode.myweather.presentation.ui.home_weather.HomeWeatherEvents.LoadWeather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeWeatherViewModel(
    private val weatherUseCase: WeatherUseCase,
): BaseViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _isLoading

    private val _nameHah = MutableStateFlow("null")
    val nameHah: StateFlow<String> = _nameHah

    fun onTriggerEvents(event: HomeWeatherEvents) {
        when (event) {
            is LoadWeather -> {
                loadWeather(event.locationTrigger)
            }
        }
    }

    private fun loadWeather(locationTrigger: LocationTrigger) {
        _isLoading.value = true
        viewModelScope.launch {
            weatherUseCase.getWeatherByLatLon(
                lat = locationTrigger.lat,
                lon = locationTrigger.lon
            ) {
                _isLoading.value = false
            }.collectLatest { it ->
                Timber.d(it.name)
                it.name?.let {
                    Timber.d("Hahaha $it")
                    _nameHah.value = it
                }
            }
        }
    }

}