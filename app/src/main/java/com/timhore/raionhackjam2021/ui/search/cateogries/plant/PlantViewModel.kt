package com.timhore.raionhackjam2021.ui.search.cateogries.plant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.timhore.raionhackjam2021.data.Dummy
import kotlinx.coroutines.Dispatchers

class PlantViewModel : ViewModel() {

    fun getPlantsSearch(query: String) =
        Dummy
            .getPlantsSearch(query)
}