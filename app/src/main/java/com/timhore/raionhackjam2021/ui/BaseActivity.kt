package com.timhore.raionhackjam2021.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.base_nav_host)
        binding.baseBottomNav.setupWithNavController(navController)
    }
}