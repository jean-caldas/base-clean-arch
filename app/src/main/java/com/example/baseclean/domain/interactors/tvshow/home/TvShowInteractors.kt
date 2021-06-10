package com.example.baseclean.domain.interactors.tvshow.home

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowInteractors @Inject constructor(
    val getPopularTvShows: GetPopularTvShows
)