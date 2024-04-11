package com.example.onlinetoursapp.feature.search.data.network

import com.example.onlinetoursapp.common.network.SearchApi
import com.example.onlinetoursapp.feature.search.data.model.CitiesResponse
import com.example.onlinetoursapp.feature.search.domain.model.CitiesData
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchApi: SearchApi
) : SearchRepository {

    override suspend fun getCities(): CitiesData =
        searchApi.getCities().toCitiesData()

}

fun CitiesResponse.toCitiesData(): CitiesData =
    CitiesData(
        id = id,
        name = name
    )