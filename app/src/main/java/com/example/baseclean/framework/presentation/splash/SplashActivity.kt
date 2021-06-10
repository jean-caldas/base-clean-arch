package com.example.baseclean.framework.presentation.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baseclean.databinding.SplashActivityBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}