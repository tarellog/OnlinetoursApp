package com.example.onlinetoursapp.feature.data.hotel.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultResponse(
    val results: List<SearchResultResponse>
)

@Serializable
data class SearchResultResponse(
    val offer: SearchResponse,
    val count: Int
)

@Serializable
data class SearchResponse(
    @SerialName("hotel_id")
    val hotelId: Int,
    val price: Price,
    @SerialName("depart_city_id")
    val departCityId: Int,
    @SerialName("region_id")
    val regionId: Int,
    val adults: Int,
    @SerialName("start_date")
    val startDate: String,
    val duration: Int,
    @SerialName("original_name")
    val originalName: String,
)

@Serializable
data class Price(
    val total: Long
)
