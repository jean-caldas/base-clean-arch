package com.example.baseclean.framework.presentation.tvshow.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baseclean.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
