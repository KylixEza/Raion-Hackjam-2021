package com.timhore.raionhackjam2021.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.timhore.raionhackjam2021.data.Dummy
import kotlinx.coroutines.Dispatchers

class HomeViewModel : ViewModel() {

    fun getAllTrendingEvents() = Dummy.getAllTrendingEvents().asLiveData(Dispatchers.IO)
    fun getAllTrendingPlants() = Dummy.getAllTrendingPlants().asLiveData(Dispatchers.IO)
    fun getAllPlants() = Dummy.getAllPlants().asLiveData(Dispatchers.IO)
}