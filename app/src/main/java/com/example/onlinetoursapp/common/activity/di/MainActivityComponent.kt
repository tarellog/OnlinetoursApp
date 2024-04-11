package com.example.onlinetoursapp.common.activity.di

import com.example.onlinetoursapp.common.activity.MainActivity
import com.example.onlinetoursapp.common.application.di.AppComponent
import dagger.Component

@MainActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [AppComponent::class]
)
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): MainActivityComponent
    }
}