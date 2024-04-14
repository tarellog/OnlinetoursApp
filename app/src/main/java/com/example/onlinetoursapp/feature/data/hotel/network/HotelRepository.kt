package com.example.onlinetoursapp.feature.data.hotel.network

import com.example.onlinetoursapp.feature.data.hotel.model.SearchBody
import com.example.onlinetoursapp.feature.domain.model.GetSearchKeyData
import com.example.onlinetoursapp.feature.domain.model.HotelData

interface HotelRepository {
    suspend fun createSearch(searchBody: SearchBody): GetSearchKeyData
    suspend fun getHotel(key: String): List<HotelData>
}