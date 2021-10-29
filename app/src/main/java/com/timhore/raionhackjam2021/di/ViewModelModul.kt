package com.timhore.raionhackjam2021.di

import com.timhore.raionhackjam2021.ui.detail.DetailViewModel
import com.timhore.raionhackjam2021.ui.home.HomeViewModel
import com.timhore.raionhackjam2021.ui.market.MarketViewModel
import com.timhore.raionhackjam2021.ui.profile.ProfileViewModel
import com.timhore.raionhackjam2021.ui.recommendation.RecommendationViewModel
import com.timhore.raionhackjam2021.ui.search.SearchViewModel
import com.timhore.raionhackjam2021.ui.search.cateogries.article.ArticleViewModel
import com.timhore.raionhackjam2021.ui.search.cateogries.plant.PlantViewModel
import com.timhore.raionhackjam2021.ui.search.cateogries.product.ProductViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { RecommendationViewModel() }
    viewModel { MarketViewModel() }
    viewModel { SearchViewModel() }
    viewModel { DetailViewModel() }
    viewModel { ArticleViewModel() }
    viewModel { PlantViewModel() }
    viewModel { ProductViewModel() }
}