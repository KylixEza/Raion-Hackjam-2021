package com.timhore.raionhackjam2021.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.timhore.raionhackjam2021.adapter.diffutil.PlantDiffUtilCallback
import com.timhore.raionhackjam2021.databinding.ItemListSearchProductBinding
import com.timhore.raionhackjam2021.model.Plant
import com.timhore.raionhackjam2021.util.Formatting

class SearchProductAdapter: RecyclerView.Adapter<SearchProductAdapter.SearchProductViewHolder>() {

    private val listOfSearchProduct = ArrayList<Plant>()

    fun setAllItems(data: List<Plant>) {
        val diffCallback = PlantDiffUtilCallback()
        diffCallback.setPlanList(listOfSearchProduct, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        listOfSearchProduct.apply {
            clear()
            addAll(data)
        }
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchProductViewHolder {
        val view = ItemListSearchProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchProductViewHolder, position: Int) {
        holder.bind(listOfSearchProduct[position])
    }

    override fun getItemCount(): Int = listOfSearchProduct.size

    inner class SearchProductViewHolder(private val view: ItemListSearchProductBinding)
        : RecyclerView.ViewHolder(view.root) {
        fun bind(plant: Plant) {
            view.apply {
                Glide.with(itemView.context)
                    .load(plant.image)
                    .into(ivPlant)
                tvTitle.text = plant.name
                tvPrice.text = String.format("Rp ${Formatting.rupiahCurrencyFormatting(plant.price)}")
                tvLocation.text = plant.location
                tvRatingAndSold.text = String.format("${plant.rating} | ${plant.sold} terjual")
            }
        }

    }
}