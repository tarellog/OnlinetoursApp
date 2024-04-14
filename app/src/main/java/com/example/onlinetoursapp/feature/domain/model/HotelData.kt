package com.example.onlinetoursapp.feature.domain.model

import com.example.onlinetoursapp.feature.data.hotel.model.Price

data class HotelData(
    val hotelId: Int,
    val price: Price,
    val departCityId: Int,
    val regionId: Int,
    val adults: Int,
    val startDate: String,
    val duration: Int,
    val originalName: String,
)
