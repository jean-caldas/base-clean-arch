package com.example.baseclean.framework.datasource.tvshow.network

import com.example.baseclean.domain.data.tvshow.TvShowDataSource
import com.example.baseclean.domain.models.tvshow.home.TvShow
import javax.inject.Inject

class TvShowRemoteDataSource
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