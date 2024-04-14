package com.example.onlinetoursapp.feature.data.hotel.network

import com.example.onlinetoursapp.common.network.SearchApi
import com.example.onlinetoursapp.feature.data.hotel.mapper.toGetKey
import com.example.onlinetoursapp.feature.data.hotel.mapper.toHotelData
import com.example.onlinetoursapp.feature.data.hotel.model.SearchBody
import com.example.onlinetoursapp.feature.domain.model.GetSearchKeyData
import com.example.onlinetoursapp.feature.domain.model.HotelData
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val searchApi: SearchApi
) : HotelRepository {

    override suspend fun createSearch(searchBody: SearchBody): GetSearchKeyData {
        return searchApi.createSearch(searchBody).toGetKey()
    }

    override suspend fun getHotel(key: String): List<HotelData> =
        searchApi.getSearchResult(key).results.toHotelData()

}