package com.example.onlinetoursapp.common.application

import android.app.Application
import android.content.Context
import com.example.onlinetoursapp.common.application.di.AppComponent
import com.example.onlinetoursapp.common.application.di.DaggerAppComponent

class ToursApplication : Application() {

    private lateinit var _appComponent: AppComponent
    val appComponent get() = _appComponent

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
            .apply { inject(this@ToursApplication) }
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is ToursApplication -> appComponent
        else -> this.applicationContext.appComponent
    }