package com.example.onlinetoursapp.feature.search.data.network

import com.example.onlinetoursapp.common.network.SearchApi
import com.example.onlinetoursapp.feature.search.data.mapper.toCitiesData
import com.example.onlinetoursapp.feature.search.data.mapper.toGetKey
import com.example.onlinetoursapp.feature.search.data.mapper.toRegionsData
import com.example.onlinetoursapp.feature.search.data.mapper.toSearchResultData
import com.example.onlinetoursapp.feature.search.data.model.SearchBody
import com.example.onlinetoursapp.feature.search.domain.model.CitiesData
import com.example.onlinetoursapp.feature.search.domain.model.GetSearchKeyData
import com.example.onlinetoursapp.feature.search.domain.model.RegionsData
import com.example.onlinetoursapp.feature.search.domain.model.SearchResultData
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchApi: SearchApi
) : SearchRepository {

    override suspend fun getCities(): List<CitiesData> =
        searchApi.getCities().toCitiesData()

    override suspend fun getRegions(): List<RegionsData> =
        searchApi.getRegions().toRegionsData()

    override suspend fun createSearch(searchBody: SearchBody): GetSearchKeyData {
        return searchApi.createSearch(searchBody).toGetKey()
    }

    override suspend fun getSearchResult(key: String): List<SearchResultData> =
        searchApi.getSearchResult(key).results.toSearchResultData()

}