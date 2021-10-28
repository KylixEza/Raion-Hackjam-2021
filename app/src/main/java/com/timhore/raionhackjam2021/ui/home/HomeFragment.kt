package com.timhore.raionhackjam2021.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.timhore.raionhackjam2021.adapter.PlantAdapter
import com.timhore.raionhackjam2021.adapter.TrendingEventAdapter
import com.timhore.raionhackjam2021.databinding.FragmentHomeBinding
import com.timhore.raionhackjam2021.model.Event
import com.timhore.raionhackjam2021.model.Plant
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private val viewModel: HomeViewModel by viewModel()
    private lateinit var trendingEventAdapter: TrendingEventAdapter
    private lateinit var trendingPlantAdapter: PlantAdapter
    private lateinit var homeShopAdapter: PlantAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trendingEventAdapter = TrendingEventAdapter()
        trendingPlantAdapter = PlantAdapter()
        homeShopAdapter = PlantAdapter()

        binding?.apply {
            rvTrendingEvents.apply {
                adapter = trendingEventAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                viewModel.getAllTrendingEvents().observe(viewLifecycleOwner, ::trendingEventsObserver)
            }
            rvTrendingPlants.apply {
                adapter = trendingPlantAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                viewModel.getAllTrendingPlants().observe(viewLifecycleOwner, ::trendingPlantsObserver)
            }
            rvLetsShopPlants.apply {
                adapter = homeShopAdapter
                layoutManager = GridLayoutManager(requireContext(), 2)
                viewModel.getAllPlants().observe(viewLifecycleOwner, ::homeShopObserver)
            }
        }
    }

    private fun homeShopObserver(list: List<Plant>?) = list?.let { homeShopAdapter.setAllItems(it) }

    private fun trendingPlantsObserver(list: List<Plant>?) = list?.let { trendingPlantAdapter.setAllItems(it) }

    private fun trendingEventsObserver(list: List<Event>?) = list?.let { trendingEventAdapter.setAllItems(it) }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}