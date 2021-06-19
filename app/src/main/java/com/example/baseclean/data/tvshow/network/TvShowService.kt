package com.example.baseclean.data.tvshow.network

import retrofit2.http.GET
import retrofit2.http.Path

interface TvShowService {
    @GET("tv/{endPoint}")
    suspend fun getTvShows(@Path("endPoint") endPoint: String): ResultDTO
}