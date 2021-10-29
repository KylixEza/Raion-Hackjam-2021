package com.timhore.raionhackjam2021.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.timhore.raionhackjam2021.model.Event

class ArticleDiffUtilCallback: DiffUtil.Callback() {

    private var oldEventList: List<Event> = ArrayList()
    private var newEventList: List<Event> = ArrayList()

    fun setEventList(oldList: List<Event>, newList: List<Event>) {
        oldEventList = oldList
        newEventList = newList
    }

    override fun getOldListSize(): Int = oldEventList.size

    override fun getNewListSize(): Int = newEventList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldEventList[oldItemPosition].eventId == newEventList[newItemPosition].eventId

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldEventList[oldItemPosition].title == newEventList[newItemPosition].title
}