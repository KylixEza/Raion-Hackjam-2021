package com.timhore.raionhackjam2021.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.timhore.raionhackjam2021.adapter.diffutil.PlantDiffUtilCallback
import com.timhore.raionhackjam2021.databinding.ItemListPlantBinding
import com.timhore.raionhackjam2021.model.Plant

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    private val listOfPlant = ArrayList<Plant>()

    fun setAllItems(data: List<Plant>) {
        val diffCallback = PlantDiffUtilCallback()
        diffCallback.setPlanList(listOfPlant, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        listOfPlant.apply {
            clear()
            addAll(data)
        }
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlantAdapter.PlantViewHolder {
        val view = ItemListPlantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantAdapter.PlantViewHolder, position: Int) {
        holder.bind(listOfPlant[position])
    }

    override fun getItemCount(): Int = listOfPlant.size

    inner class PlantViewHolder(private val view: ItemListPlantBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(plant: Plant) {

        }
    }
}