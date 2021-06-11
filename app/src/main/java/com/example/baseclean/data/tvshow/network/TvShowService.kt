package com.example.baseclean.data.tvshow.network

import retrofit2.http.GET

interface TvShowService {
    @GET("tv/popular")
    suspend fun getPopularTvShows(): ResultDTO
}