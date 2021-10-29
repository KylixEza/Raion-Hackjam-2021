package com.timhore.raionhackjam2021.ui.market

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.adapter.SearchProductAdapter
import com.timhore.raionhackjam2021.databinding.FragmentHomeBinding
import com.timhore.raionhackjam2021.databinding.FragmentMarketBinding
import com.timhore.raionhackjam2021.model.Plant

class MarketFragment : Fragment() {

    companion object {
        fun newInstance() = MarketFragment()
    }

    private lateinit var viewModel: MarketViewModel

    private var _binding: FragmentMarketBinding? = null
    private val binding get() = _binding
    private lateinit var diskonSpesialAdapter : SearchProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_market, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MarketViewModel::class.java)

        diskonSpesialAdapter = SearchProductAdapter()

        binding?.apply {
            rvDiskonSpesial.apply {
                adapter = diskonSpesialAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
            rvTanamanLaris.apply {
                adapter = diskonSpesialAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }

        }

    }

//    private fun diskonSpesialObserver(list: List<Plant>?) = list?.let { SearchProductAdapter.setAllItems(it) }

//    private fun tanamanLarisObserver(list: List<Plant>?) = list?.let { SearchProductAdapter.setAllItems(it) }

}