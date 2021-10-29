package com.timhore.raionhackjam2021.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.timhore.raionhackjam2021.ui.search.SearchFragment
import com.timhore.raionhackjam2021.ui.search.cateogries.article.ArticleFragment
import com.timhore.raionhackjam2021.ui.search.cateogries.plant.PlantFragment
import com.timhore.raionhackjam2021.ui.search.cateogries.product.ProductFragment

class SearchViewPager(
    fm: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = SearchFragment.TAB_SEARCH_TITLES.size

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = PlantFragment()
            1 -> fragment = ProductFragment()
            2 -> fragment = ArticleFragment()
        }
        return fragment as Fragment
    }
}