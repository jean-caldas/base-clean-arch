package com.example.baseclean.ui.tvshow.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.baseclean.R
import com.example.baseclean.databinding.TvshowTrendingBinding
import com.example.baseclean.domain.common.models.DataState
import com.example.baseclean.ui.common.mappers.PORTRAIT
import com.example.baseclean.ui.tvshow.home.HomeViewModel
import com.example.baseclean.ui.tvshow.trending.epoxy.TvShowController
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

const val TV_POPULAR = 0
const val TV_TOP_RATED = 1

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

        binding.seriesSelectionTab.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                displayProgressBar(true)
                when(tab?.position){
                    TV_POPULAR -> {
                        model.getPopularTvShows()
                    }
                    TV_TOP_RATED -> {
                        model.getTopRatedShows()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })

        return binding.root
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