package com.example.onlinetoursapp.feature.search.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinetoursapp.feature.search.domain.model.RegionsData

class RegionsDiffCallback : DiffUtil.ItemCallback<RegionsData>() {

    override fun areItemsTheSame(oldItem: RegionsData, newItem: RegionsData): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: RegionsData, newItem: RegionsData): Boolean =
        oldItem == newItem

}