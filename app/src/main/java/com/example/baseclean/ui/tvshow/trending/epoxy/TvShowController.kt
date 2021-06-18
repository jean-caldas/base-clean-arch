package com.example.baseclean.ui.tvshow.trending.epoxy

import com.airbnb.epoxy.EpoxyController
import com.example.baseclean.domain.models.tvshow.home.TvShow
import com.example.baseclean.tvserieItem

class TvShowController() : EpoxyController() {

    var tvShows: List<TvShow>? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        tvShows?.forEach {
            tvserieItem {
                id(it.id)
                tvShow(it)
            }
        }
    }
}