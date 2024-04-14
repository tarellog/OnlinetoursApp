package com.example.onlinetoursapp.feature.presenter

import com.example.onlinetoursapp.feature.domain.usecase.SearchUseCase
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class ToursSearchPresenter @Inject constructor(
    private val searchUseCase: SearchUseCase
) : MvpPresenter<ToursSearchView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadSearchData()
    }

    private fun loadSearchData() {
        presenterScope.launch {
            searchUseCase.observeToSearch().collect {
                viewState.setDataByTypeSearch(it.from, it.to)
            }
        }
    }

}