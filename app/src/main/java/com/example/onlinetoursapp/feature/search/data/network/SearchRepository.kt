package com.example.onlinetoursapp.feature.search.data.network

import com.example.onlinetoursapp.feature.search.domain.model.CitiesData

interface SearchRepository {
    suspend fun getCities(): CitiesData
}