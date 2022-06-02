package com.lnmcode.myweather.mapper

/**
 * T is domain
 * H is entity
 * */
interface EntityMapper<T> {
    fun toEntity(): T
}