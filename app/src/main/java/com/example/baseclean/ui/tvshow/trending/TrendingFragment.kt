package com.example.baseclean.ui.tvshow.trending

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.baseclean.R
import com.example.baseclean.databinding.TvshowTrendingBinding
import com.example.baseclean.domain.models.tvshow.home.TvShow
import com.example.baseclean.domain.common.models.DataState
import com.example.baseclean.ui.common.mappers.PORTRAIT
import com.example.baseclean.ui.tvshow.home.HomeViewModel
import com.example.baseclean.ui.tvshow.trending.epoxy.TvShowController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingFragment : Fragment() {

    private lateinit var binding: TvshowTrendingBinding
    private lateinit var epoxyTvShowController: TvShowController
    private val model: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TvshowTrendingBinding.inflate(inflater)
        epoxyTvShowController = TvShowController()
        binding.epoxyTvShowsRecycler.setController(epoxyTvShowController)

        val orientation = resources.configuration.orientation

        val spanCount =
            if (orientation == PORTRAIT) resources.getInteger(R.integer.span_count_tvshows_portrait)
            else resources.getInteger(R.integer.span_count_tvshows_landscape)

        binding.epoxyTvShowsRecycler.layoutManager = GridLayoutManager(requireContext(), spanCount)

        return binding.root
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Toast.makeText(requireContext(), "CAMBIO CONFIG DESDE FRAGMENT", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        subscribeObservers()
        model.getPopularTvShows()
    }


    private fun subscribeObservers() {
        model.dataState.observe(this, {
            when (it) {
                is DataState.Success -> {
                    displayProgressBar(false)
                    //displayShowNames(it.data)
                    epoxyTvShowController.tvShows = it.data
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(it.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }

        })
    }

    private fun displayError(message: String?) {
        //TODO
    }

    private fun displayProgressBar(display: Boolean) {
        binding.progressBar.visibility = if (display) View.VISIBLE else View.GONE
    }
}