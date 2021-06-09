package com.example.baseclean.framework.datasource.tvshow.network

import retrofit2.http.GET

interface TvShowRetrofit {
    @GET("tv/popular")
    suspend fun getPopularTvShows():List<TvShowNetworkEntity>
}