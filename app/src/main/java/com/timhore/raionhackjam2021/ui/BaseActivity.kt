package com.timhore.raionhackjam2021.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = resources.getColor(R.color.splash_dark_green)
        }

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.base_nav_host)
        binding.baseBottomNav.setupWithNavController(navController)
    }
}