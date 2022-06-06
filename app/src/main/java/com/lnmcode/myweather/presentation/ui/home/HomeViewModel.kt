package com.lnmcode.myweather.presentation.ui.home

import androidx.lifecycle.viewModelScope
import com.lnmcode.myweather.datasource.usecase.WeatherUseCase
import com.lnmcode.myweather.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(
    private val weatherUseCase: WeatherUseCase,
) : BaseViewModel() {

    val haha = "https://s7d2.scene7.com/is/image/TWCNews/0801_n13_chuluotaweatherjpg"

    fun getWeather() {
        viewModelScope.launch {
            weatherUseCase.getWeatherByLatLon("39.31", "-74.5") {
                Timber.d("Xong")
            }.collectLatest {
                Timber.d(it.name)
            }
        }
    }
}