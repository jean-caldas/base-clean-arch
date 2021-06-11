package com.example.baseclean.ui.tvshow.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

const val NUMBER_OF_PAGES = 3

class TvShowPagerAdapter(fa: FragmentActivity, private val tvTabs: List<Fragment>) :
    FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return NUMBER_OF_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return tvTabs[position]
    }
}