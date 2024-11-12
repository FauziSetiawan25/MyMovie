package com.example.mymovie

import retrofit2.Call
import com.example.mymovie.modeldata.SearchData
import retrofit2.http.GET

interface Api {
    @GET("?s=naruto&apikey=b75232ab")
    fun getMovies():Call<SearchData>

}