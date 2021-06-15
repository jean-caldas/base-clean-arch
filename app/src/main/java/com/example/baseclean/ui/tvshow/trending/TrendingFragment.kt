package com.example.baseclean.ui.tvshow.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.baseclean.databinding.TvshowTrendingBinding
import com.example.baseclean.domain.models.tvshow.home.TvShow
import com.example.baseclean.ui.common.models.DataState
import com.example.baseclean.ui.tvshow.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingFragment : Fragment() {

    private lateinit var binding: TvshowTrendingBinding
    private val model: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TvshowTrendingBinding.inflate(inflater)
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
                    displayShowNames(it.data)
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
        binding.textView.text = message ?: "Unknown error"
    }

    private fun displayProgressBar(display: Boolean) {
        binding.progressBar.visibility = if (display) View.VISIBLE else View.GONE
    }

    private fun displayShowNames(tvShows: List<TvShow>) {
        val sb = StringBuilder()
        for (tvShow in tvShows) sb.appendLine(tvShow.name)
        binding.textView.text = sb.toString()
    }
}