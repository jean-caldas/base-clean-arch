package com.example.baseclean.domain.interactors.tvshow.home

import com.example.baseclean.domain.common.models.DataState
import com.example.baseclean.domain.common.models.ErrorType
import com.example.baseclean.domain.gateways.tvshow.TvShowContract
import com.example.baseclean.domain.models.tvshow.home.TvShow
import javax.inject.Inject

class GetTopRated
@Inject constructor() {

    companion object {
        private const val END_POINT = "top_rated"
    }

    @Inject
    lateinit var source: TvShowContract

    suspend operator fun invoke(): DataState<List<TvShow>> {
        return try {
            val tvShows = source.getTvShows(END_POINT)
            DataState.Success(tvShows)
        } catch (e: Exception) {
            DataState.Error(ErrorType.NETWORK, e.hashCode(), e.message)
        }
    }
}