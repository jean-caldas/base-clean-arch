package com.example.baseclean.domain.interactors.tvshow.home

import com.example.baseclean.di.RemoteTvShow
import com.example.baseclean.domain.gateways.tvshow.TvShowDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPopularTvShows
@Inject
constructor() {
    @RemoteTvShow
    @Inject
    lateinit var source: TvShowDataSource
    suspend operator fun invoke() = source.getAll()
}