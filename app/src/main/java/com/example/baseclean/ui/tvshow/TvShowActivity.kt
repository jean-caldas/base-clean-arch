package com.example.baseclean.ui.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baseclean.databinding.HomeActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowActivity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
