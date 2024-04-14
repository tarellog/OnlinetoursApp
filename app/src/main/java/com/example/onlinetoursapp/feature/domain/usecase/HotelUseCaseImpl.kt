package com.example.onlinetoursapp.feature.domain.usecase

import com.example.onlinetoursapp.feature.data.hotel.model.CreateSearchBody
import com.example.onlinetoursapp.feature.data.hotel.model.SearchBody
import com.example.onlinetoursapp.feature.data.hotel.network.HotelRepository
import com.example.onlinetoursapp.feature.di.SearchScope
import com.example.onlinetoursapp.feature.domain.model.GetSearchKeyData
import com.example.onlinetoursapp.feature.domain.model.HotelData
import javax.inject.Inject

@SearchScope
class HotelUseCaseImpl @Inject constructor(
    private val hotelRepository: HotelRepository,
    private val searchUseCase: SearchUseCase
) {

    suspend fun getHotel(): List<HotelData> {
        return hotelRepository.getHotel(getSearchKey().key)
    }

    /**
     * Данные с выбором даты , количество дней и взрозлых захардкожены, в тз про это ничего не сказано.
     */
    private suspend fun getSearchKey(): GetSearchKeyData =
        hotelRepository.createSearch(
            SearchBody(
                CreateSearchBody(
                    searchUseCase.observeToSearch().value.from.cityId ?: 0,
                    listOf(searchUseCase.observeToSearch().value.to.regionId ?: 0),
                    "2024-04-17",
                    "2024-04-30",
                    7,
                    17,
                    2
                )
            )
        )

}