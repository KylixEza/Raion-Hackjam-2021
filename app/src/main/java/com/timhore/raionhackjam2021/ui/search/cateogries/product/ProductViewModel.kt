package com.timhore.raionhackjam2021.ui.search.cateogries.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.timhore.raionhackjam2021.data.Dummy
import kotlinx.coroutines.Dispatchers

class ProductViewModel : ViewModel() {

    fun getProductsSearch(query: String) =
        Dummy
            .getProductsSearch(query)
            .asLiveData(Dispatchers.IO)
}