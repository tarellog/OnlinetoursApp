package com.example.onlinetoursapp.feature.data.search.network

import com.example.onlinetoursapp.feature.domain.model.CitiesData
import com.example.onlinetoursapp.feature.domain.model.RegionsData

interface SearchRepository {
    suspend fun getCities(): List<CitiesData>
    suspend fun getRegions(): List<RegionsData>
}