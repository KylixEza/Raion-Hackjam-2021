package com.timhore.raionhackjam2021.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.timhore.raionhackjam2021.model.Event

class ArticleDiffUtilCallback: DiffUtil.Callback() {

    private var oldArticleList: List<Event> = ArrayList()
    private var newArticleList: List<Event> = ArrayList()

    fun setEventList(oldList: List<Event>, newList: List<Event>) {
        oldArticleList = oldList
        newArticleList = newList
    }

    override fun getOldListSize(): Int = oldArticleList.size

    override fun getNewListSize(): Int = newArticleList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldArticleList[oldItemPosition].eventId == newArticleList[newItemPosition].eventId

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldArticleList[oldItemPosition].title == newArticleList[newItemPosition].title
}