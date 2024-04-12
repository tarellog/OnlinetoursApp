package com.example.onlinetoursapp.feature.search.domain.model

import com.example.onlinetoursapp.feature.search.data.model.Price

data class SearchResultData(
    val hotelId: Int,
    val price: Price,
    val departCityId: Int,
    val regionId: Int,
    val adults: Int,
    val startDate: String,
    val duration: Int,
    val originalName: String,
)
