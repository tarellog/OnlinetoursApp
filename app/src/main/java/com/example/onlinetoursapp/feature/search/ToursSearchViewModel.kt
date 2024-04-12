package com.example.onlinetoursapp.feature.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinetoursapp.feature.search.data.model.CreateSearchBody
import com.example.onlinetoursapp.feature.search.data.model.SearchBody
import com.example.onlinetoursapp.feature.search.data.network.SearchRepository
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class ToursSearchViewModel @AssistedInject constructor(
    private val searchRepository: SearchRepository,
) : ViewModel() {

    fun okey() {
        viewModelScope.launch {
            try {
                val result = searchRepository.createSearch(
                    SearchBody(
                        CreateSearchBody(
                        422,
                        listOf(352),
                        "2024-04-17",
                        "2024-04-30",
                        7,
                        17,
                        2
                    )
                    )
                )
                Log.d("MyTag", "${result}")
                Log.d("MyTag", "${result.key}")
                val ok = searchRepository.getSearchResult(result.key)
                ok.map {
                    Log.d("MyTag", "list = ${it}")
                }
            } catch (e: Exception) {
                Log.e("MyTag", "Error", e)
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): ToursSearchViewModel
    }

}