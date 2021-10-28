package com.timhore.raionhackjam2021.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timhore.raionhackjam2021.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}