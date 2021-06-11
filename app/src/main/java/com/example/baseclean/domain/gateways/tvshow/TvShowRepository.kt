package com.example.baseclean.domain.gateways.tvshow

import com.example.baseclean.domain.models.tvshow.home.TvShow
import com.example.baseclean.ui.common.models.DataState

class TvShowRepository(private val dataSource: TvShowDataSource) {

    suspend fun getPopularTvShows(): DataState<List<TvShow>> {
        return try {
            val tvShows = dataSource.getAll()
            DataState.Success(tvShows)
        } catch (e: Exception) {
            DataState.Error(e)
        }
    }

}