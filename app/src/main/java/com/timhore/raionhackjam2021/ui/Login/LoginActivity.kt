package com.timhore.raionhackjam2021.ui.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timhore.raionhackjam2021.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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