package com.timhore.raionhackjam2021.ui.detail.product

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.databinding.ActivityPlantDetailBinding
import com.timhore.raionhackjam2021.databinding.ActivityProductDetailBinding
import com.timhore.raionhackjam2021.model.Plant
import com.timhore.raionhackjam2021.ui.detail.DetailViewModel
import com.timhore.raionhackjam2021.ui.detail.plant.PlantDetailActivityArgs
import com.timhore.raionhackjam2021.util.Formatting
import org.koin.android.viewmodel.ext.android.viewModel

class ProductDetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()
    private val viewBinding: ActivityProductDetailBinding by viewBinding()
    private val args: PlantDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = resources.getColor(R.color.splash_dark_green)
        }

        val plantId = args.plantId

        val plant = viewModel.getDetailPlant(plantId)
        observer(plant)
    }

    private fun observer(plant: Plant?) {
        viewBinding.apply {
            Glide.with(this@ProductDetailActivity)
                .load(plant?.image)
                .into(ivImageDetail)
            tvPlantName.text = plant?.name
            tvPlantLatinName.text = plant?.latinName
            tvDescription.text = plant?.description
            tvPrice.text = String.format("Rp ${Formatting.rupiahCurrencyFormatting(plant?.price)}")
            includeFakeAppBarDetail.tvDetailTitle.text = "Detail Produk"
        }
    }
}