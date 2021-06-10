package com.example.baseclean.domain.interactors.tvshow.home

import com.example.baseclean.domain.gateways.tvshow.TvShowRepository

class GetPopularTvShows (private val repository: TvShowRepository) {
    suspend operator fun invoke() = repository.getPopularTvShows()
}