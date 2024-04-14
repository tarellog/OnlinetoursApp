package com.example.onlinetoursapp.feature.data.search.mapper

import com.example.onlinetoursapp.feature.data.search.model.CitiesResponse
import com.example.onlinetoursapp.feature.data.search.model.RegionsResponse
import com.example.onlinetoursapp.feature.domain.model.CitiesData
import com.example.onlinetoursapp.feature.domain.model.RegionsData

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