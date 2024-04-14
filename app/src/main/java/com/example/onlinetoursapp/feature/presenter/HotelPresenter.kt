package com.example.onlinetoursapp.feature.presenter

import android.util.Log
import com.example.onlinetoursapp.feature.domain.usecase.HotelUseCaseImpl
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class HotelPresenter @Inject constructor(
    private val hotelUseCaseImpl: HotelUseCaseImpl
): MvpPresenter<HotelView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadHotelData()
    }

    private fun loadHotelData() {
        presenterScope.launch {
            try {
                val listHotel = hotelUseCaseImpl.getHotel()
                viewState.loadHotelData(listHotel)
            } catch (e: Exception) {
                Log.e("tag", "Exception", e)
            }
        }
    }

}