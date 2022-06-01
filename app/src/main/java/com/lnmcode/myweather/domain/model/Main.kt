package com.lnmcode.myweather.domain.model

data class Main(
    val temp: Double? = null,
    val tempMin: Double? = null,
    val grndLevel: Int? = null,
    val humidity: Int? = null,
    val pressure: Int? = null,
    val seaLevel: Int? = null,
    val feelsLike: Double? = null,
    val tempMax: Double? = null
)
