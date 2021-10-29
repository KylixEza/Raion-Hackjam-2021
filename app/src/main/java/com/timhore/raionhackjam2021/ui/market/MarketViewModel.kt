package com.timhore.raionhackjam2021.ui.market

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.timhore.raionhackjam2021.data.Dummy
import kotlinx.coroutines.Dispatchers

class MarketViewModel : ViewModel() {

    fun getPlants() =
        Dummy
            .getAllTrendingPlants()
            .asLiveData(Dispatchers.IO)

}