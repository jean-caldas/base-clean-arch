package com.example.baseclean.data.tvshow.network

import com.example.baseclean.domain.gateways.tvshow.TvShowDataSource
import com.example.baseclean.domain.models.tvshow.home.TvShow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowNetworkDataSource
@Inject
constructor(
    private val tvShowRetrofit: TvShowRetrofit,
    private val tvShowMapper: TvShowMapper
) : TvShowDataSource {
    override suspend fun getAll(): List<TvShow> {
        val tvShows = tvShowRetrofit.getPopularTvShows()
        return tvShowMapper.mapFromEntityList(tvShows)
    }
}