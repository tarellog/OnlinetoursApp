package com.example.onlinetoursapp.feature.search

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ToursSearchViewModel @AssistedInject constructor(

) : ViewModel() {

    fun okey() {

    }

    @AssistedFactory
    interface Factory {
        fun create(): ToursSearchViewModel
    }

}