package com.timhore.raionhackjam2021.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.timhore.raionhackjam2021.adapter.diffutil.PlantDiffUtilCallback
import com.timhore.raionhackjam2021.databinding.ItemListHomeRecommendationBinding
import com.timhore.raionhackjam2021.model.Plant

class HomeRecommendationAdapter: RecyclerView.Adapter<HomeRecommendationAdapter.HomeViewHolder>() {

    private val listOfHomeRecommendation = ArrayList<Plant>()

    fun setAllItems(data: List<Plant>) {
        val diffCallback = PlantDiffUtilCallback()
        diffCallback.setPlanList(listOfHomeRecommendation, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        listOfHomeRecommendation.apply {
            clear()
            addAll(data)
        }
        diffResult.dispatchUpdatesTo(this)
    }

    inner class HomeViewHolder(private val view: ItemListHomeRecommendationBinding)
        : RecyclerView.ViewHolder(view.root) {
        fun bind(plant: Plant) {
            Glide.with(itemView.context)
                .load(plant.image)
                .into(view.ivPlant)
            view.tvTitle.text = plant.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRecommendationAdapter.HomeViewHolder {
        val view = ItemListHomeRecommendationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: HomeRecommendationAdapter.HomeViewHolder,
        position: Int
    ) {
        holder.bind(listOfHomeRecommendation[position])
    }

    override fun getItemCount(): Int = listOfHomeRecommendation.size
}