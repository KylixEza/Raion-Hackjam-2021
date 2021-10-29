package com.timhore.raionhackjam2021.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.google.android.material.tabs.TabLayoutMediator
import com.timhore.raionhackjam2021.adapter.SearchViewPager
import com.timhore.raionhackjam2021.databinding.FragmentSearchBinding
import com.timhore.raionhackjam2021.util.Constanta

class SearchFragment : Fragment() {

    companion object {
        val TAB_SEARCH_TITLES = listOf<String>(
            "Tanaman",
            "Produk",
            "Artikel"
        )
    }

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagerAdapter = SearchViewPager(
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding?.apply {
            viewPager.adapter = pagerAdapter
            TabLayoutMediator(tabSearch, viewPager) { tab, position ->
                tab.text = TAB_SEARCH_TITLES[position]
            }.attach()

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (query != null) {
                        Constanta.QUERY = query
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean = false

            })
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}