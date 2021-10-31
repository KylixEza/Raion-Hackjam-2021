package com.timhore.raionhackjam2021.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.timhore.raionhackjam2021.data.Dummy
import kotlinx.coroutines.Dispatchers

class DetailViewModel: ViewModel() {

    fun getDetailPlant(plantId: String) =
        Dummy
            .getDetailPlant(plantId)

    fun getRelatePlant() =
        Dummy
            .getAllTrendingPlants()
            .asLiveData(Dispatchers.IO)
}