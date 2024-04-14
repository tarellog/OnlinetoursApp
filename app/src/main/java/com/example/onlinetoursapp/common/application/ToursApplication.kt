package com.example.onlinetoursapp.common.application

import android.app.Application
import com.example.onlinetoursapp.common.application.di.AppComponent
import com.example.onlinetoursapp.common.application.di.DaggerAppComponent

class ToursApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
            .apply { inject(this@ToursApplication) }
    }

    companion object {
        private lateinit var _appComponent: AppComponent
        val appComponent get() = _appComponent
    }

}