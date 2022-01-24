package com.example.appmovies.network

import com.example.appmovies.services.Utils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiAdapter {
    private const val baseUrl = "https://api.themoviedb.org/3/"

    private val client: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request().newBuilder().addHeader("Authorization", "Bearer ${Utils.bearerToken}").build()
        chain.proceed(request)
    }.build()

    val apiClient: ApiClient = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiClient::class.java)
}