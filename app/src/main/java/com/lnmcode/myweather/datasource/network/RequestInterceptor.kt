package com.lnmcode.myweather.datasource.network

import com.lnmcode.myweather.BuildConfig
import com.lnmcode.myweather.utils.QUERY_PARAMETER_APP_ID
import com.lnmcode.myweather.utils.QUERY_PARAMETER_UNITS
import com.lnmcode.myweather.utils.QUERY_PARAMETER_UNITS_VALUE
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class RequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter(QUERY_PARAMETER_APP_ID, BuildConfig.KEY_API)
            .addQueryParameter(QUERY_PARAMETER_UNITS, QUERY_PARAMETER_UNITS_VALUE)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        Timber.d(request.toString())
        return chain.proceed(request)
    }
}