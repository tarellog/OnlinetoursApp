package com.example.onlinetoursapp.feature.di

import com.example.onlinetoursapp.feature.data.hotel.network.HotelRepository
import com.example.onlinetoursapp.feature.data.hotel.network.HotelRepositoryImpl
import com.example.onlinetoursapp.feature.data.search.network.SearchRepository
import com.example.onlinetoursapp.feature.data.search.network.SearchRepositoryImpl
import com.example.onlinetoursapp.feature.presenter.HotelPresenter
import com.example.onlinetoursapp.feature.presenter.HotelView
import com.example.onlinetoursapp.feature.presenter.SearchPresenter
import com.example.onlinetoursapp.feature.presenter.SearchView
import com.example.onlinetoursapp.feature.presenter.ToursSearchPresenter
import com.example.onlinetoursapp.feature.presenter.ToursSearchView
import dagger.Binds
import dagger.Module
import moxy.MvpPresenter

@Module
interface SearchFeatureModule {
    @[SearchScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository
    @[SearchScope Binds]
    fun bindHotelRepository(impl: HotelRepositoryImpl): HotelRepository
    @[SearchScope Binds]
    fun bindSearchPresenter(impl: SearchPresenter): MvpPresenter<SearchView>
    @[SearchScope Binds]
    fun bindToursSearchPresenter(impl: ToursSearchPresenter): MvpPresenter<ToursSearchView>
    @[SearchScope Binds]
    fun bindHotelPresenter(impl: HotelPresenter): MvpPresenter<HotelView>
}