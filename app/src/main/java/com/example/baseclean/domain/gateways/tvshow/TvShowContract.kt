package com.example.baseclean.domain.gateways.tvshow

import com.example.baseclean.domain.models.tvshow.home.TvShow

interface TvShowContract {
    suspend fun getAll(): List<TvShow>
}