package com.timhore.raionhackjam2021.ui.search.cateogries.plant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.adapter.SearchPlantAdapter
import com.timhore.raionhackjam2021.databinding.FragmentPlantBinding
import com.timhore.raionhackjam2021.model.Plant
import com.timhore.raionhackjam2021.util.Constanta
import org.koin.android.viewmodel.ext.android.viewModel

class PlantFragment : Fragment() {

    private val viewModel: PlantViewModel by viewModel()
    private val binding: FragmentPlantBinding by viewBinding()
    private lateinit var adapter: SearchPlantAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_plant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SearchPlantAdapter()

        binding.rvSearchPlant.apply {
            adapter = this@PlantFragment.adapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            viewModel.getPlantsSearch(Constanta.QUERY).observe(viewLifecycleOwner, ::observer)
        }
    }

    private fun observer(list: List<Plant>?) {
        list?.let { adapter.setAllItems(it) }
    }

}