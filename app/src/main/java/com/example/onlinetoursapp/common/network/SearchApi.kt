package com.example.onlinetoursapp.common.network

import com.example.onlinetoursapp.feature.search.data.model.CitiesResponse
import com.example.onlinetoursapp.feature.search.data.model.GetSearchKeyResponse
import com.example.onlinetoursapp.feature.search.data.model.RegionsResponse
import com.example.onlinetoursapp.feature.search.data.model.ResultResponse
import com.example.onlinetoursapp.feature.search.data.model.SearchBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchApi {
    @POST("searches/")
    suspend fun createSearch(@Body searchBody: SearchBody): GetSearchKeyResponse

    @GET("searches/{key}/results")
    suspend fun getSearchResult(
        @Path("key") key: String,
        @Query("limit") page: Int = 10,
    ): ResultResponse

    @GET("depart_cities")
    suspend fun getCities(): List<CitiesResponse>

    @GET("regions")
    suspend fun getRegions(): List<RegionsResponse>

}