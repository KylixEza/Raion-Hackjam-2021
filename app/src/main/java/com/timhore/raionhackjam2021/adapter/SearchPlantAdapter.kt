package com.timhore.raionhackjam2021.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.timhore.raionhackjam2021.adapter.diffutil.PlantDiffUtilCallback
import com.timhore.raionhackjam2021.databinding.ItemListSearchPlantBinding
import com.timhore.raionhackjam2021.model.Plant
import com.timhore.raionhackjam2021.ui.home.HomeFragmentDirections

class SearchPlantAdapter: RecyclerView.Adapter<SearchPlantAdapter.SearchPlantViewHolder>() {

    private val listOfSearchPlant = ArrayList<Plant>()

    fun setAllItems(data: List<Plant>) {
        val diffCallback = PlantDiffUtilCallback()
        diffCallback.setPlanList(listOfSearchPlant, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        listOfSearchPlant.apply {
            clear()
            addAll(data)
        }
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPlantViewHolder {
        val view = ItemListSearchPlantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchPlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchPlantViewHolder, position: Int) {
        holder.bind(listOfSearchPlant[position])
    }

    override fun getItemCount(): Int = listOfSearchPlant.size

    inner class SearchPlantViewHolder(private val view: ItemListSearchPlantBinding)
        : RecyclerView.ViewHolder(view.root) {
        fun bind(plant: Plant) {
            view.apply {
                Glide.with(itemView.context)
                    .load(plant.image)
                    .into(ivPlant)
                tvTitle.text = plant.name
                tvLatinName.text = plant.latinName
                itemView.setOnClickListener {
                    it.findNavController().navigate(HomeFragmentDirections
                        .actionNavigationHomeToProductDetailActivity(plant.id))
                }
            }
        }

    }
}