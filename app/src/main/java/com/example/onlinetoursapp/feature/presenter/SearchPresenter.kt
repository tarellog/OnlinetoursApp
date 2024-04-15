package com.example.onlinetoursapp.feature.presenter

import android.util.Log
import com.example.onlinetoursapp.feature.data.search.network.SearchRepository
import com.example.onlinetoursapp.feature.domain.model.CitiesData
import com.example.onlinetoursapp.feature.domain.model.RegionsData
import com.example.onlinetoursapp.feature.domain.model.SearchFrom
import com.example.onlinetoursapp.feature.domain.model.SearchTo
import com.example.onlinetoursapp.feature.domain.usecase.SearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val searchRepository: SearchRepository,
    private val searchUseCase: SearchUseCase
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
                val citesData = searchRepository.getCities()
                viewState.loadCitiesData(citesData)
            } catch (e: Exception) {
                Log.e("tag", "Exception", e)
            }
        }
    }

    fun searchCity() {
        presenterScope.launch(Dispatchers.Main) {
            try {
                val citesData = searchRepository.getCities()
                val selectedCity = citesData.filter { _city == it.name }
                viewState.loadCitiesData(selectedCity)
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

    fun searchRegion() {
        presenterScope.launch(Dispatchers.Main) {
            try {
                val regions = searchRepository.getRegions()
                val selectedRegion = regions.filter { _city == it.name }
                viewState.loadRegionData(selectedRegion)
            } catch (e: Exception) {
                Log.e("tag", "Exception", e)
            }
        }
    }

    fun onClickItemByCity(item: CitiesData) {
        _city = item.name
        viewState.onDismiss()
        searchUseCase.setCityToSearch(SearchFrom(item.name, item.id.toInt()))
    }

    fun onClickItemByRegion(item: RegionsData) {
        _city = item.name
        viewState.onDismiss()
        searchUseCase.setRegionToSearch(SearchTo(item.name, item.id.toInt()))
    }

}