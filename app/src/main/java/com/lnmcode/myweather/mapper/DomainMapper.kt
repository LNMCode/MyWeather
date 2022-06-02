package com.lnmcode.myweather.mapper

interface DomainMapper<T> {
    fun toDomain(): T
}