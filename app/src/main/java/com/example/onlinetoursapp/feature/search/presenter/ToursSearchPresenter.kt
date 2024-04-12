package com.example.onlinetoursapp.feature.search.presenter

import android.util.Log
import com.example.onlinetoursapp.feature.search.data.model.CreateSearchBody
import com.example.onlinetoursapp.feature.search.data.model.SearchBody
import com.example.onlinetoursapp.feature.search.data.network.SearchRepository
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class ToursSearchPresenter @Inject constructor(
    private val searchRepository: SearchRepository
) : MvpPresenter<ToursSearchView>() {

    private var _cityId = 0
    private var _regionId = 0

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun setCityId(cityId: Int) {
        _cityId = cityId
    }

    fun setRegionId(cityId: Int) {
        _regionId = cityId
    }

    fun okey() {
        presenterScope.launch {
            try {
                searchRepository.createSearch(
                    SearchBody(
                        CreateSearchBody(
                            _cityId,
                            listOf(_regionId),
                            "2024-04-17",
                            "2024-04-30",
                            7,
                            17,
                            2
                        )
                    )
                )
            } catch (e: Exception) {
                Log.e("MyTag", "Error", e)
            }
        }
    }

}