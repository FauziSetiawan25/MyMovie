package com.example.mymovie.modeldata

import com.google.gson.annotations.SerializedName

data class MovieData (
    val Title:String,
    val Year:String,
    @SerializedName("Poster") val gambar:String
)