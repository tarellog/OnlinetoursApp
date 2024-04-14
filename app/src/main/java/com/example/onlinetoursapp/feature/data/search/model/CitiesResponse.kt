package com.example.onlinetoursapp.feature.data.search.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CitiesResponse(
    val id: Long,
    val name: String,
    @SerialName("country_id")
    val countryId: Long,
    @SerialName("country_name")
    val countryName: String,
)
