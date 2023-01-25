package com.realityexpander.cleanarchitecturenoteapp.network

import com.realityexpander.cleanarchitecturenoteapp.network.APIResponse.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApiService {
    @GET("v1/search")
    suspend fun getSearchedImage(
        @Query("query")
        searchQuery:String,
        @Query("per_page")
        page:Int
    ): Response<APIResponse>
}