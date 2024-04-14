package com.example.onlinetoursapp.feature.data.hotel.model

import kotlinx.serialization.Serializable

@Serializable
data class GetSearchKeyResponse(
    val key: String
)