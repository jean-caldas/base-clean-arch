package com.example.baseclean.ui.tvshow.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TvShowPagerAdapter (fa: FragmentActivity, private val tvTabs: List<Fragment>) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return tvTabs[position]
    }
}