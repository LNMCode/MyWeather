package com.lnmcode.myweather.di

import com.lnmcode.myweather.datasource.network.NetworkConnectionInterceptor
import com.lnmcode.myweather.datasource.network.RequestInterceptor
import com.lnmcode.myweather.datasource.network.helper.ApiService
import com.lnmcode.myweather.utils.BASE_URL_API
import com.lnmcode.myweather.utils.BASE_URL_NAME
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {

    single(named(BASE_URL_NAME)) { baseUrlString() }

    single(named("RequestInterceptor")) { RequestInterceptor() }

    single(named("NetworkConnectionInterceptor")) { NetworkConnectionInterceptor(get()) }

    single {
        okHttpClientBuilder(
            get(qualifier = named("RequestInterceptor")),
            get(qualifier = named("NetworkConnectionInterceptor"))
        )
    }

    single { moshiBuilder() }

    single { retrofitBuilder(get(), get(qualifier = named(BASE_URL_NAME))) }

    // service
    single { get<Retrofit>().create(ApiService::class.java) }
}

internal fun okHttpClientBuilder(
    interceptor: RequestInterceptor,
    networkConnectionInterceptor: NetworkConnectionInterceptor,
): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(networkConnectionInterceptor)
        .addInterceptor(interceptor)
        .build()
}

internal fun moshiBuilder(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
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