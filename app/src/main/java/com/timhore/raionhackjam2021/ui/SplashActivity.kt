package com.timhore.raionhackjam2021.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.timhore.raionhackjam2021.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler(mainLooper)
        handler.postDelayed({
            startActivity(Intent(this, BaseActivity::class.java))
            finish()
        }, 2000L)

    }
}