package com.example.onlinetoursapp.feature.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.onlinetoursapp.feature.search.domain.model.RegionsData

class RegionsAdapter(
    private val onClickItem: (RegionsData) -> Unit
) : ListAdapter<RegionsData, RegionsViewHolder>(RegionsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RegionsViewHolder(parent)

    override fun onBindViewHolder(holder: RegionsViewHolder, position: Int) {
        holder.bind(getItem(position), onClickItem)
    }

}