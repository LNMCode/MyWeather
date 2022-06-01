package com.lnmcode.myweather.datasource.network

interface DomainMapper<T> {
    fun toDomain(): T
}