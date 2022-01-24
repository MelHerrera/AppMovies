package com.example.appmovies.network

import com.example.appmovies.dto.ResponsePopularMovies
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    //Obtener la informacion de las peliculas populares actuales
    @GET("movie/popular")
    suspend fun getPopularMovies(
    ):Response<ResponsePopularMovies>
}