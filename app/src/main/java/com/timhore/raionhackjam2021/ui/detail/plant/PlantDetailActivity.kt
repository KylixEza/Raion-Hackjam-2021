package com.timhore.raionhackjam2021.ui.detail.plant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.databinding.ActivityPlantDetailBinding

class PlantDetailActivity : AppCompatActivity() {

    private val binding: ActivityPlantDetailBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_detail)
    }
}