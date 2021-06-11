package com.example.baseclean.ui.tvshow.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.baseclean.databinding.TvshowTrendingBinding

class TrendingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = TvshowTrendingBinding.inflate(inflater)
        return view.root
    }
}