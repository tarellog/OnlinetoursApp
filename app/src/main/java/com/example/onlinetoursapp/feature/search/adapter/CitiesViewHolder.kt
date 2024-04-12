package com.example.onlinetoursapp.feature.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinetoursapp.databinding.ItemSearchCitiesBinding
import com.example.onlinetoursapp.feature.search.domain.model.CitiesData

class CitiesViewHolder(private val binding: ItemSearchCitiesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ItemSearchCitiesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    fun bind(item: CitiesData, onClickItem: (CitiesData) -> Unit) {
        binding.cityName.text = item.name
        binding.cityName.setOnClickListener { onClickItem(item) }
    }

}