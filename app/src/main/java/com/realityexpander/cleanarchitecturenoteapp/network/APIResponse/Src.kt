package com.realityexpander.cleanarchitecturenoteapp.network.APIResponse

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Src(
    @SerializedName("original") val original : String,
    @SerializedName("large2x") val large2x : String,
    @SerializedName("large") val large : String,
    @SerializedName("medium") val medium : String,
    @SerializedName("small") val small : String,
    @SerializedName("portrait") val portrait : String,
    @SerializedName("landscape") val landscape : String,
    @SerializedName("tiny") val tiny : String
): Serializable