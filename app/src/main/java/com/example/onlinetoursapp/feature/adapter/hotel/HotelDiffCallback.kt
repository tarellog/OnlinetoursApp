package com.example.onlinetoursapp.feature.adapter.hotel

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinetoursapp.feature.domain.model.HotelData

class HotelDiffCallback : DiffUtil.ItemCallback<HotelData>() {

    override fun areItemsTheSame(oldItem: HotelData, newItem: HotelData): Boolean =
        oldItem.hotelId == newItem.hotelId

    override fun areContentsTheSame(oldItem: HotelData, newItem: HotelData): Boolean =
        oldItem == newItem

}