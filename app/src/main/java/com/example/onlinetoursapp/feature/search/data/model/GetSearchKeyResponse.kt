package com.example.onlinetoursapp.feature.search.data.model

import kotlinx.serialization.Serializable

@Serializable
data class GetSearchKeyResponse(
    val key: String
)