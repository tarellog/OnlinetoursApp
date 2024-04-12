package com.example.onlinetoursapp.feature.search.data.network

import com.example.onlinetoursapp.feature.search.data.model.SearchBody
import com.example.onlinetoursapp.feature.search.domain.model.CitiesData
import com.example.onlinetoursapp.feature.search.domain.model.GetSearchKeyData
import com.example.onlinetoursapp.feature.search.domain.model.RegionsData
import com.example.onlinetoursapp.feature.search.domain.model.SearchResultData

interface SearchRepository {
    suspend fun getCities(): List<CitiesData>
    suspend fun getRegions(): List<RegionsData>
    suspend fun createSearch(searchBody: SearchBody): GetSearchKeyData
    suspend fun getSearchResult(key: String): List<SearchResultData>
}