package com.example.baseclean.domain.interactors.tvshow.home

import com.example.baseclean.domain.gateways.tvshow.TvShowContract
import com.example.baseclean.domain.models.tvshow.home.TvShow
import com.example.baseclean.domain.common.models.DataState
import com.example.baseclean.domain.common.models.ErrorType
import javax.inject.Inject

class GetPopularTvShows
@Inject
constructor() {
    //@RemoteTvShow
    @Inject
    lateinit var source: TvShowContract

    suspend operator fun invoke(): DataState<List<TvShow>> {
        return try {
            val tvShows = source.getAll()
            DataState.Success(tvShows)
        } catch (e: Exception) {
            DataState.Error(ErrorType.NETWORK, e.hashCode(), e.message)
        }
    }
}