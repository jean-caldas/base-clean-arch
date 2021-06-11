package com.example.baseclean.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.baseclean.R
import com.example.baseclean.databinding.ActivityMainBinding
import com.example.baseclean.domain.models.tvshow.home.TvShow
import com.example.baseclean.ui.common.models.DataState
import com.example.baseclean.ui.tvshow.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val model: HomeViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subscribeObservers()
        model.getPupularTvShows()
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
                    displayError(it.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }

        })
    }

    private fun displayError(message: String?) {
        binding.text.text = message ?: "Unknown error"
    }

    private fun displayProgressBar(display: Boolean) {
        binding.progressBar.visibility = if (display) View.VISIBLE else View.GONE
    }

    private fun displayShowNames(tvShows: List<TvShow>) {
        val sb = StringBuilder()
        for (tvShow in tvShows) sb.appendLine(tvShow.name)
        binding.text.text = sb.toString()
    }
}