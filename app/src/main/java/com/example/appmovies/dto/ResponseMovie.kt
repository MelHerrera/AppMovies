package com.example.appmovies.dto

import com.google.gson.annotations.SerializedName

data class ResponseMovie(
    @SerializedName("adult") var adult:Boolean,
    @SerializedName("original_title") var title:String,
    @SerializedName("poster_path") var poster:String
)

data class ResponsePopularMovies(
    @SerializedName("page") var page:Int,
    @SerializedName("total_results") var totalResults:Int,
    @SerializedName("results") var results:ArrayList<ResponseMovie>
)