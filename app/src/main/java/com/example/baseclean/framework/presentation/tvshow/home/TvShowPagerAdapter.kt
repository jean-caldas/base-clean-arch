package com.example.baseclean.framework.presentation.tvshow.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TvShowPagerAdapter (fa: FragmentActivity, val tvTabs: List<Fragment>) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 0
    }

    override fun createFragment(position: Int): Fragment {
        return tvTabs[0]
    }
}