package com.example.onlinetoursapp.feature.search.presenter

import com.example.onlinetoursapp.feature.search.domain.model.CitiesData
import com.example.onlinetoursapp.feature.search.domain.model.RegionsData
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface SearchView: MvpView {
    fun loadCitiesData(list: List<CitiesData>)
    fun loadRegionData(list: List<RegionsData>)
    fun onDismiss(city: String, departCityId: Int? = null, regionId: Int? = null)
}