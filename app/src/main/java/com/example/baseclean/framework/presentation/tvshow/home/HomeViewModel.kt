package com.example.baseclean.framework.presentation.tvshow.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseclean.domain.models.tvshow.home.TvShow
import com.example.baseclean.domain.interactors.tvshow.home.TvShowInteractors
import com.example.baseclean.framework.common.DataState
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel
@Inject
constructor(
    private val interactors: TvShowInteractors
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<TvShow>>> = MutableLiveData()
    val dataState
        get() = _dataState

    fun getPupularTvShows() {
        viewModelScope.launch {
            interactors.getPopularTvShows.invoke()
        }
    }
}