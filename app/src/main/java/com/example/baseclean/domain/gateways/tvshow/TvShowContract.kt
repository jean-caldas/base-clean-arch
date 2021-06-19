package com.example.baseclean.domain.gateways.tvshow

import com.example.baseclean.domain.models.tvshow.home.TvShow

interface TvShowContract {
    suspend fun getTvShows(endPoint: String): List<TvShow>
}