    package com.timhore.raionhackjam2021.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.databinding.ActivityDetailBinding
import com.timhore.raionhackjam2021.model.Plant
import com.timhore.raionhackjam2021.ui.BaseActivity
import com.timhore.raionhackjam2021.util.Formatting
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()
    private val viewBinding: ActivityDetailBinding by viewBinding()
    private val args: DetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val plantId = args.plantId

        viewModel.getDetailPlant(plantId).observe(this, ::detailPlantObserver)
    }

    private fun detailPlantObserver(plant: Plant?) {
        viewBinding.apply {
            Glide.with(this@DetailActivity)
                .load(plant?.image)
                .into(ivImageDetail)
            tvPlantName.text = plant?.name
            tvPlantLatinName.text = plant?.latinName
            tvPrice.text = String.format("Rp ${Formatting.rupiahCurrencyFormatting(plant?.price)}")
            tvDescription.text = plant?.description
            tvWatering.text = plant?.watering
            tvTemperature.text = plant?.temperature
            tvPlace.text = plant?.place

            includeFakeAppBarDetail.ivArrowBack.setOnClickListener {
                startActivity(Intent(this@DetailActivity, BaseActivity::class.java))
                finish()
            }
        }
    }
}