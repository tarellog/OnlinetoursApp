package com.example.onlinetoursapp.feature.search.presenter

import android.util.Log
import com.example.onlinetoursapp.feature.search.data.network.SearchRepository
import com.example.onlinetoursapp.feature.search.domain.model.CitiesData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val searchRepository: SearchRepository,
) : MvpPresenter<SearchView>() {

    private var _city = ""

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCitiesData()
    }

    fun onChangeListener(city: String) {
        _city = city
    }

    private fun loadCitiesData() {
        presenterScope.launch(Dispatchers.Main) {
            try {
                val citesData = searchRepository.getCities().take(10)
                viewState.loadCitiesData(citesData)
            } catch (e: Exception) {
                Log.e("tag", "Exception", e)
            }
        }
    }

    fun onClickItem(item: CitiesData) {
        _city = item.name
        viewState.onDismiss(_city, item.id.toInt())
    }

}