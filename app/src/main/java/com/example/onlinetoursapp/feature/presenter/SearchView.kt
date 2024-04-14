package com.example.onlinetoursapp.feature.presenter

import com.example.onlinetoursapp.feature.domain.model.CitiesData
import com.example.onlinetoursapp.feature.domain.model.RegionsData
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface SearchView: MvpView {
    fun loadCitiesData(list: List<CitiesData>)
    fun loadRegionData(list: List<RegionsData>)
    fun onDismiss()
}