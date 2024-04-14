package com.example.onlinetoursapp.feature.data.hotel.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchBody(
    val search: CreateSearchBody
)

@Serializable
data class CreateSearchBody(
    @SerialName("depart_city_id")
    val departCityId: Int,
    @SerialName("region_ids")
    val regionIds: List<Int>,
    @SerialName("start_from")
    val startFrom: String,
    @SerialName("start_to")
    val startTo: String,
    @SerialName("duration_from")
    val durationFrom: Int,
    @SerialName("duration_to")
    val durationTo: Int,
    val adults: Int
)
