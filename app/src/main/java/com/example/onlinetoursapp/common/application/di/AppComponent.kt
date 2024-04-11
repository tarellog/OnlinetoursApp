package com.example.onlinetoursapp.common.application.di

import android.app.Application
import com.example.onlinetoursapp.common.application.ToursApplication
import com.example.onlinetoursapp.common.network.SearchApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        ApiModule::class
    ]
)
interface AppComponent {

    fun inject(app: ToursApplication)
    fun getSearchApi(): SearchApi

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}