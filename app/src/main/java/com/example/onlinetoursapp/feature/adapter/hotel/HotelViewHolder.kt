package com.example.onlinetoursapp.feature.adapter.hotel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinetoursapp.R
import com.example.onlinetoursapp.databinding.ItemHotelBinding
import com.example.onlinetoursapp.feature.domain.model.HotelData

class HotelViewHolder(private val binding: ItemHotelBinding) :
    RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ItemHotelBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    fun bind(item: HotelData) {
        binding.hotelTitle.text = item.originalName
        binding.hotelAmount.text =
            binding.root.context.getString(R.string.total_amount, item.price.total)
        binding.hotelToNumber.text = item.startDate
        binding.hotelNightQuantity.text = item.duration.toString()
    }

}