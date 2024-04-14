package com.example.onlinetoursapp.feature.adapter.hotel

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.onlinetoursapp.feature.domain.model.HotelData

class HotelAdapter : ListAdapter<HotelData, HotelViewHolder>(HotelDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HotelViewHolder(parent)

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}