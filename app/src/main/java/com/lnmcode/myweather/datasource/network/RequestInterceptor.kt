package com.lnmcode.myweather.datasource.network

import com.lnmcode.myweather.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class RequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("appid", BuildConfig.KEY_API)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        Timber.d(request.toString())
        return chain.proceed(request)
    }
}