package com.example.baseclean.framework.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.baseclean.R
import com.example.baseclean.databinding.SplashBinding
import java.util.*
import kotlin.concurrent.schedule

class SplashFragment : Fragment() {

    private lateinit var binding: SplashBinding
    private lateinit var navControl: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashBinding.inflate(inflater)
        navControl = findNavController()
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        Timer("SettingUp", false).schedule(3000) {
            requireActivity().runOnUiThread {
                navControl.navigate(R.id.action_splashFragment_to_tvshows_navigation)
            }
        }

    }

}