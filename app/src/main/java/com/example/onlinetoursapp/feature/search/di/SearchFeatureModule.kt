package com.example.onlinetoursapp.feature.search.di

import com.example.onlinetoursapp.feature.search.data.network.SearchRepository
import com.example.onlinetoursapp.feature.search.data.network.SearchRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface SearchFeatureModule {
    @Binds
    fun provideSearchRepository(impl: SearchRepositoryImpl): SearchRepository
}