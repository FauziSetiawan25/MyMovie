package com.example.mymovie.modeldata

import com.google.gson.annotations.SerializedName

data class SearchData(
    @SerializedName("Search") val data:List<MovieData>,
    @SerializedName("totalResults") val totalData:Int
)
