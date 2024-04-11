package com.example.onlinetoursapp.common.application.di

import com.example.onlinetoursapp.common.network.SearchApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun provideSearchApi(retrofit: Retrofit): SearchApi = retrofit.create(SearchApi::class.java)

}