package com.example.onlinetoursapp.feature.domain.model

data class SearchModel(
    val from: SearchFrom = SearchFrom(),
    val to: SearchTo = SearchTo()
)
