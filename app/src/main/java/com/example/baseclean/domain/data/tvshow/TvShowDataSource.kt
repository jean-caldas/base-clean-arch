package com.example.baseclean.domain.data.tvshow

import com.example.baseclean.domain.models.tvshow.home.TvShow

interface TvShowDataSource {
    suspend fun getAll(): List<TvShow>
}