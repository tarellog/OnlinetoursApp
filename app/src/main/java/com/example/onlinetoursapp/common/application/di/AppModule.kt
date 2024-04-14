package com.example.onlinetoursapp.common.application.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @ApplicationScope
    @Provides
    fun context(application: Application): Context = application.applicationContext
}