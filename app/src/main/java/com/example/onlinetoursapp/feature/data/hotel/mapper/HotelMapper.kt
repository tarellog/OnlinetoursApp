package com.example.onlinetoursapp.feature.data.hotel.mapper

import com.example.onlinetoursapp.feature.data.hotel.model.GetSearchKeyResponse
import com.example.onlinetoursapp.feature.data.hotel.model.SearchResultResponse
import com.example.onlinetoursapp.feature.domain.model.GetSearchKeyData
import com.example.onlinetoursapp.feature.domain.model.HotelData

fun GetSearchKeyResponse.toGetKey(): GetSearchKeyData = GetSearchKeyData(key)

fun List<SearchResultResponse>.toHotelData(): List<HotelData> =
    this.map {
        HotelData(
            it.offer.hotelId,
            it.offer.price,
            it.offer.departCityId,
            it.offer.regionId,
            it.offer.adults,
            it.offer.startDate,
            it.offer.duration,
            it.offer.originalName
        )
    }