package com.timhore.raionhackjam2021.ui.market

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.adapter.SearchProductAdapter
import com.timhore.raionhackjam2021.databinding.FragmentMarketBinding
import com.timhore.raionhackjam2021.model.Plant
import org.koin.android.viewmodel.ext.android.viewModel

class MarketFragment : Fragment() {


    private val binding: FragmentMarketBinding by viewBinding()
    private lateinit var diskonSpesialAdapter : SearchProductAdapter
    private lateinit var tanamanSpesialAdapter: SearchProductAdapter
    private val viewModel: MarketViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_market, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tanamanSpesialAdapter = SearchProductAdapter()
        diskonSpesialAdapter = SearchProductAdapter()

        binding?.apply {
            rvDiskonSpesial.apply {
                adapter = diskonSpesialAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                viewModel.getPlants().observe(viewLifecycleOwner, ::diskonSpesialObserver)
            }
            rvTanamanLaris.apply {
                adapter = diskonSpesialAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                viewModel.getPlants().observe(viewLifecycleOwner, ::tanamanLarisObserver)
            }

        }

    }

    private fun diskonSpesialObserver(list: List<Plant>?) = list?.let { diskonSpesialAdapter.setAllItems(it) }
    private fun tanamanLarisObserver(list: List<Plant>?) = list?.let { tanamanSpesialAdapter.setAllItems(it) }

}