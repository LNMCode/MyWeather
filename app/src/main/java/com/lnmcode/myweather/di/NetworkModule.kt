package com.lnmcode.myweather.di

import com.lnmcode.myweather.datasource.network.RequestInterceptor
import com.lnmcode.myweather.datasource.network.helper.ApiService
import com.lnmcode.myweather.utils.BASE_URL_API
import com.lnmcode.myweather.utils.BASE_URL_NAME
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {

    single(named(BASE_URL_NAME)) { baseUrlString() }

    single { RequestInterceptor() }

    single { okHttpClientBuilder(get()) }

    single { retrofitBuilder(get(), get()) }

    // service
    single { get<Retrofit>().create(ApiService::class.java) }
}

internal fun okHttpClientBuilder(
    interceptor: RequestInterceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
}


internal fun retrofitBuilder(
    okHttpClient: OkHttpClient,
    baseUrlString: String,
): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUrlString)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

internal fun baseUrlString(): String {
    //"this is base url string for request api"
    return BASE_URL_API
}