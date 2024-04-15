package com.example.onlinetoursapp.feature.domain.usecase

import com.example.onlinetoursapp.feature.di.FeatureScope
import com.example.onlinetoursapp.feature.domain.model.SearchFrom
import com.example.onlinetoursapp.feature.domain.model.SearchModel
import com.example.onlinetoursapp.feature.domain.model.SearchTo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@FeatureScope
class SearchUseCase @Inject constructor() {

    private val searchTest = MutableStateFlow(SearchModel())

    fun setRegionToSearch(searchTo: SearchTo) {
        searchTest.tryEmit(searchTest.value.copy(to = searchTo))
    }

    fun setCityToSearch(searchFrom: SearchFrom) {
        searchTest.tryEmit(searchTest.value.copy(from = searchFrom))
    }

    fun observeToSearch(): StateFlow<SearchModel> =
        searchTest.asStateFlow()

}