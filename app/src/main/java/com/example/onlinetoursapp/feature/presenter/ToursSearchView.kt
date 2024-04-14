package com.example.onlinetoursapp.feature.presenter

import com.example.onlinetoursapp.feature.domain.model.SearchFrom
import com.example.onlinetoursapp.feature.domain.model.SearchTo
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ToursSearchView : MvpView {
    @StateStrategyType(SingleStateStrategy::class)
    fun setDataByTypeSearch(searchFrom: SearchFrom, searchTo: SearchTo)
}