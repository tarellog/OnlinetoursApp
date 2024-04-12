package com.example.onlinetoursapp.feature.search.data.mapper

import com.example.onlinetoursapp.feature.search.data.model.CitiesResponse
import com.example.onlinetoursapp.feature.search.data.model.GetSearchKeyResponse
import com.example.onlinetoursapp.feature.search.data.model.RegionsResponse
import com.example.onlinetoursapp.feature.search.data.model.SearchResultResponse
import com.example.onlinetoursapp.feature.search.domain.model.CitiesData
import com.example.onlinetoursapp.feature.search.domain.model.GetSearchKeyData
import com.example.onlinetoursapp.feature.search.domain.model.RegionsData
import com.example.onlinetoursapp.feature.search.domain.model.SearchResultData

fun List<CitiesResponse>.toCitiesData(): List<CitiesData> =
    this.map {
        CitiesData(
            id = it.id,
            name = it.name
        )
    }

fun List<RegionsResponse>.toRegionsData(): List<RegionsData> =
    this.map {
        RegionsData(
            id = it.id,
            name = it.name,
            type = it.type,
            countryName = it.countryName ?: "",
            countryId = it.countryId ?: 0
        )
    }

fun GetSearchKeyResponse.toGetKey(): GetSearchKeyData = GetSearchKeyData(key)

fun List<SearchResultResponse>.toSearchResultData(): List<SearchResultData> =
    this.map {
        SearchResultData(
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