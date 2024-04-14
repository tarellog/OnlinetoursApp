package com.example.onlinetoursapp.feature.presenter

import com.example.onlinetoursapp.feature.domain.model.HotelData
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface HotelView : MvpView {
    @StateStrategyType(SingleStateStrategy::class)
    fun loadHotelData(hotelData: List<HotelData>)
}