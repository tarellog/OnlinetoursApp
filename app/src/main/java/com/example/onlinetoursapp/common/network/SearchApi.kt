package com.example.onlinetoursapp.common.network

import com.example.onlinetoursapp.feature.search.data.model.CitiesResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SearchApi {
    @POST("searches/")
    suspend fun registerUser(
    )

    @GET("searches/{key}/results")
    suspend fun getSearchResult(
        @Path("key") key: String
    )

    @GET("depart_cities")
    suspend fun getCities(): CitiesResponse

}