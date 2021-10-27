package com.timhore.raionhackjam2021.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.timhore.raionhackjam2021.adapter.diffutil.EventDiffUtilCallback
import com.timhore.raionhackjam2021.databinding.ItemListTrendingEventBinding
import com.timhore.raionhackjam2021.model.Event

class TrendingEventAdapter: RecyclerView.Adapter<TrendingEventAdapter.TrendingEventViewHolder>() {

    private val listOfTrendingEvent = ArrayList<Event>()

    fun setAllItems(data: List<Event>) {
        val diffCallback = EventDiffUtilCallback()
        diffCallback.setEventList(listOfTrendingEvent, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        listOfTrendingEvent.apply {
            clear()
            addAll(data)
        }
        diffResult.dispatchUpdatesTo(this)
    }

    inner class TrendingEventViewHolder(
        private val view: ItemListTrendingEventBinding
        ): RecyclerView.ViewHolder(view.root) {

        fun bind(event: Event) {
            view.apply {
                tvEventBanner.text = event.title
                Glide.with(itemView.context)
                    .load(event.image)
                    .apply(RequestOptions.overrideOf(230, 120))
                    .into(ivEventBanner)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingEventViewHolder {
        val view = ItemListTrendingEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendingEventViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrendingEventViewHolder, position: Int) {
        holder.bind(listOfTrendingEvent[position])
    }

    override fun getItemCount(): Int = listOfTrendingEvent.size
}