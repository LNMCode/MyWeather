package com.lnmcode.myweather.presentation.base

import android.app.Application
import com.lnmcode.myweather.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        configDI()
        Timber.plant(Timber.DebugTree())
    }

    private fun configDI() = startKoin {
        androidLogger(Level.DEBUG)
        androidContext(this@BaseApplication)
        modules(appModule)
    }
}