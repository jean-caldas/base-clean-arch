package com.example.baseclean.ui.tvshow

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
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

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Toast.makeText(this, "CAMBIO CONFIG DESDE ACTIVITY", Toast.LENGTH_LONG).show()
    }
}
