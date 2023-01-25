package com.realityexpander.cleanarchitecturenoteapp.network.APIResponse

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id") val id : Int,
    @SerializedName("width") val width : Int,
    @SerializedName("height") val height : Int,
    @SerializedName("url") val url : String,
    @SerializedName("photographer") val photographer : String,
    @SerializedName("photographer_url") val photographer_url : String,
    @SerializedName("photographer_id") val photographer_id : Int,
    @SerializedName("avg_color") val avg_color : String,
    @SerializedName("src") val src : Src,
    @SerializedName("liked") val liked : Boolean
)