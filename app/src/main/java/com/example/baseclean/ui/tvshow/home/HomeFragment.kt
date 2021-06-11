package com.example.baseclean.ui.tvshow.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.baseclean.R
import com.example.baseclean.databinding.HomeFragmentBinding
import com.example.baseclean.ui.tvshow.search.SearchFragment
import com.example.baseclean.ui.tvshow.trending.TrendingFragment
import com.example.baseclean.ui.user.UserProfileFragment
import com.google.android.material.tabs.TabLayoutMediator

const val SEARCH = 0
const val TRENDING = 1
const val PROFILE = 2

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeFragmentBinding.inflate(inflater)
        binding.tvShowPager.adapter = TvShowPagerAdapter(
            requireActivity(),
            listOf( TrendingFragment(), SearchFragment(), UserProfileFragment())
        )

        TabLayoutMediator(binding.tvShowTab, binding.tvShowPager) { tab, position ->
            when (position) {
                SEARCH -> {
                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_home)
                }
                TRENDING -> {
                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_search)
                }
                PROFILE -> {
                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_user)
                }
            }
        }.attach()

        return binding.root
    }
}