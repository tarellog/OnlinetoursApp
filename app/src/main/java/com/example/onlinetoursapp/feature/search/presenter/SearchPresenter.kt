package com.example.onlinetoursapp.feature.search.presenter

import android.util.Log
import com.example.onlinetoursapp.feature.search.data.network.SearchRepository
import com.example.onlinetoursapp.feature.search.domain.model.CitiesData
import com.example.onlinetoursapp.feature.search.domain.model.RegionsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val searchRepository: SearchRepository,
) : MvpPresenter<SearchView>() {

    private var _city = ""
    private var typeSearch = true

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    fun onChangeListener(city: String) {
        _city = city
    }

    fun typeSearch(type: Boolean) {
        typeSearch = type
    }

    private fun loadData() {
        if (typeSearch) loadCitiesData()
        else loadRegionsData()
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

    private fun loadRegionsData() {
        presenterScope.launch(Dispatchers.Main) {
            try {
                val regions = searchRepository.getRegions()
                viewState.loadRegionData(regions)
            } catch (e: Exception) {
                Log.e("tag", "Exception", e)
            }
        }
    }

    fun onClickItem(item: CitiesData) {
        _city = item.name
        viewState.onDismiss(_city, departCityId = item.id.toInt())
    }

    fun onClickItem2(item: RegionsData) {
        viewState.onDismiss(item.name, regionId = item.id.toInt())
    }

}