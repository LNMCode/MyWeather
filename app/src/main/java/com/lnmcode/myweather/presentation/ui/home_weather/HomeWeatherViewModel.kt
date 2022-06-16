package com.lnmcode.myweather.presentation.ui.home_weather

import com.lnmcode.myweather.datasource.usecase.cache.ListLocationUseCase
import com.lnmcode.myweather.datasource.usecase.network.WeatherUseCase
import com.lnmcode.myweather.domain.model.weather.Weather
import com.lnmcode.myweather.presentation.base.BaseViewModel
import com.lnmcode.myweather.presentation.ui.home_weather.HomeWeatherEvents.GetListLocation
import com.lnmcode.myweather.presentation.ui.home_weather.HomeWeatherEvents.LoadWeather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

class HomeWeatherViewModel(
    private val weatherUseCase: WeatherUseCase,
    private val listLocationUseCase: ListLocationUseCase,
) : BaseViewModel() {

    private val _weather = MutableStateFlow(null as Weather?)
    val weather: StateFlow<Weather?> = _weather

    fun onTriggerEvents(event: HomeWeatherEvents) {
        when (event) {
            is LoadWeather -> {
                loadWeather(event.locationTrigger)
            }
            is GetListLocation -> {
                getListLocation(event.position)
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

    private fun getListLocation(position: Int) {
        requestEvent {
            listLocationUseCase.getLocation(id = position) {
                setLoading(false)
            }.collectLatest { list ->
                Timber.d(list.toString())
                val lat = list.lat
                val lon = list.lon
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