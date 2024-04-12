package com.example.onlinetoursapp.feature.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.onlinetoursapp.feature.search.domain.model.CitiesData

class SearchAdapter(
    private val onClickItem: (CitiesData) -> Unit
) : ListAdapter<CitiesData, SearchViewHolder>(SearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(parent)

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position), onClickItem)
    }

}