package com.example.onlinetoursapp.feature.data.search.network

import com.example.onlinetoursapp.common.network.SearchApi
import com.example.onlinetoursapp.feature.data.search.mapper.toCitiesData
import com.example.onlinetoursapp.feature.data.search.mapper.toRegionsData
import com.example.onlinetoursapp.feature.domain.model.CitiesData
import com.example.onlinetoursapp.feature.domain.model.RegionsData
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchApi: SearchApi
) : SearchRepository {

    override suspend fun getCities(): List<CitiesData> =
        searchApi.getCities().toCitiesData()

    override suspend fun getRegions(): List<RegionsData> =
        searchApi.getRegions().toRegionsData()

}