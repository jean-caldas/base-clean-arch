package com.example.baseclean.data.tvshow.network

import retrofit2.http.GET

interface TvShowRetrofit {
    @GET("tv/popular")
    suspend fun getPopularTvShows():List<TvShowNetworkEntity>
}