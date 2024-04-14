package com.example.onlinetoursapp.feature.data.search.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegionsResponse(
    val id: Long,
    val name: String,
    val type: String,
    @SerialName("country_id")
    val countryId: Long? = null,
    @SerialName("country_name")
    val countryName: String? = null,
    @SerialName("visa_required")
    val visaRequired: Boolean? = null,
)