package com.timhore.raionhackjam2021.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.timhore.raionhackjam2021.model.Plant

class PlantDiffUtilCallback: DiffUtil.Callback() {

    private var oldPlantList: List<Plant> = ArrayList()
    private var newPlantList: List<Plant> = ArrayList()

    fun setPlanList(oldList: List<Plant>, newList: List<Plant>) {
        oldPlantList = oldList
        newPlantList = newList
    }

    override fun getOldListSize(): Int = oldPlantList.size

    override fun getNewListSize(): Int = newPlantList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldPlantList[oldItemPosition].id == newPlantList[newItemPosition].id


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldPlantList[oldItemPosition].name == newPlantList[newItemPosition].name
}