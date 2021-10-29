package com.timhore.raionhackjam2021.ui.Login

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = resources.getColor(R.color.splash_dark_green)
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginbottomsheet = LoginBottomSheetFragment()
        val registerbottomsheet = RegisterBottomSheetFragment()

        binding.btnDaftar.setOnClickListener {
            fragmentManager?.let { it -> registerbottomsheet.show(supportFragmentManager,"Login BottomSheet showing") }
        }
        binding.btnMasuk.setOnClickListener{
            fragmentManager?.let { it -> loginbottomsheet.show(supportFragmentManager,"Login BottomSheet showing") }
        }
    }
}