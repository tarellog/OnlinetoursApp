package com.example.onlinetoursapp.feature.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.onlinetoursapp.feature.search.domain.model.CitiesData

class CitiesAdapter(
    private val onClickItem: (CitiesData) -> Unit
) : ListAdapter<CitiesData, CitiesViewHolder>(CitiesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CitiesViewHolder(parent)

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        holder.bind(getItem(position), onClickItem)
    }

}