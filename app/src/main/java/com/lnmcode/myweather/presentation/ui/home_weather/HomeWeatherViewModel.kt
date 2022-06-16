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

    private val _weather = MutableStateFlow(null as Weather?)
    val weather: StateFlow<Weather?> = _weather

    init {
        onTriggerEvents(GetListLocation)
    }

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
        requestEvent {
            weatherUseCase.getWeatherByLatLon(
                lat = locationTrigger.lat.toString(),
                lon = locationTrigger.lon.toString()
            ) {
                setLoading(false)
            }.collectLatest { weather ->
                Timber.d(weather.name)
                _weather.value = weather
            }
        }
    }

    private fun getListLocation() {
        requestEvent {
            listLocationUseCase.getAllLocations {
                setLoading(false)
            }.collectLatest { list ->
                Timber.d(list.size.toString())
                val lat = list.last().lat
                val lon = list.last().lon
                if (lat == null || lon == null) {
                    Timber.d("Lat lon getlistlocation is null")
                    return@collectLatest
                }
                val locationTrigger = LocationTrigger(lat, lon)
                onTriggerEvents(LoadWeather(locationTrigger))
            }
        }
    }

}