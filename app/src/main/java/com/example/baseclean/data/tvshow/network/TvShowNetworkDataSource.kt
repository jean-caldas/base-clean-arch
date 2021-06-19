package com.example.baseclean.data.tvshow.network

import com.example.baseclean.domain.gateways.tvshow.TvShowContract
import com.example.baseclean.domain.models.tvshow.home.TvShow

class TvShowNetworkDataSource(
    private val tvShowService: TvShowService,
    private val tvShowMapper: TvShowMapper
) : TvShowContract {
    override suspend fun getTvShows(endPoint: String): List<TvShow> {
        val result = tvShowService.getTvShows(endPoint)
        return tvShowMapper.mapFromResult(result)
    }
}