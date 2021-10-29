package com.timhore.raionhackjam2021.ui.recommendation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.adapter.PlantAdapter
import com.timhore.raionhackjam2021.databinding.FragmentRecommendationBinding
import com.timhore.raionhackjam2021.model.Plant
import org.koin.android.viewmodel.ext.android.viewModel

class RecommendationFragment : Fragment() {

    private val viewModel by viewModel<RecommendationViewModel>()
    private val binding by viewBinding<FragmentRecommendationBinding>()
    private lateinit var recommendationAdapter: PlantAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recommendation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recommendationAdapter = PlantAdapter()

        binding.rvRecommendation.apply {
            adapter = recommendationAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
            viewModel.getRecommendationPlant().observe(viewLifecycleOwner, ::observer)
        }
    }

    private fun observer(list: List<Plant>?) {
        list?.let { recommendationAdapter.setAllItems(it) }
    }

}