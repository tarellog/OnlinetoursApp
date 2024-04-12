package com.example.onlinetoursapp.feature.search.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinetoursapp.feature.search.domain.model.CitiesData

class CitiesDiffCallback : DiffUtil.ItemCallback<CitiesData>() {

    override fun areItemsTheSame(oldItem: CitiesData, newItem: CitiesData): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CitiesData, newItem: CitiesData): Boolean =
        oldItem == newItem

}