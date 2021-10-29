package com.timhore.raionhackjam2021.ui.recommendation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.timhore.raionhackjam2021.data.Dummy
import kotlinx.coroutines.Dispatchers

class RecommendationViewModel : ViewModel() {

    fun getRecommendationPlant() =
        Dummy
            .getRecommendationPlant()
            .asLiveData(Dispatchers.IO)

}