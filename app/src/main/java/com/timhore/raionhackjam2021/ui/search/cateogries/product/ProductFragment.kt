package com.timhore.raionhackjam2021.ui.search.cateogries.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.timhore.raionhackjam2021.R
import com.timhore.raionhackjam2021.adapter.SearchProductAdapter
import com.timhore.raionhackjam2021.databinding.FragmentProductBinding
import com.timhore.raionhackjam2021.model.Plant
import com.timhore.raionhackjam2021.util.Constanta
import org.koin.android.viewmodel.ext.android.viewModel

class ProductFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModel()
    private val binding: FragmentProductBinding by viewBinding()
    private lateinit var adapter: SearchProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = SearchProductAdapter()

        binding.rvSearchProduct.apply {
            adapter = this@ProductFragment.adapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            val list = viewModel.getProductsSearch(Constanta.QUERY)
            observer(list)
        }
    }

    private fun observer(list: List<Plant>?) {
        list?.let { adapter.setAllItems(it) }
    }

}