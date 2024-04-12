package com.example.onlinetoursapp.feature.search.di

import com.example.onlinetoursapp.feature.search.data.network.SearchRepository
import com.example.onlinetoursapp.feature.search.data.network.SearchRepositoryImpl
import com.example.onlinetoursapp.feature.search.presenter.SearchPresenter
import com.example.onlinetoursapp.feature.search.presenter.SearchView
import com.example.onlinetoursapp.feature.search.presenter.ToursSearchPresenter
import com.example.onlinetoursapp.feature.search.presenter.ToursSearchView
import dagger.Binds
import dagger.Module
import moxy.MvpPresenter

@Module
interface SearchFeatureModule {
    @Binds
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository
    @Binds
    fun bindSearchPresenter(impl: SearchPresenter): MvpPresenter<SearchView>
    @Binds
    fun bindToursSearchPresenter(impl: ToursSearchPresenter): MvpPresenter<ToursSearchView>
}