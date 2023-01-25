package com.realityexpander.cleanarchitecturenoteapp.network.APIResponse

import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("total_results") val total_results: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val per_page: Int,
    @SerializedName("photos") val photos: ArrayList<Photo>,
    @SerializedName("next_page") val next_page: String
)