package com.example.onlinetoursapp.feature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlinetoursapp.databinding.FragmentHotelBinding
import com.example.onlinetoursapp.feature.adapter.hotel.HotelAdapter
import com.example.onlinetoursapp.feature.di.SearchHolder
import com.example.onlinetoursapp.feature.domain.model.HotelData
import com.example.onlinetoursapp.feature.presenter.HotelPresenter
import com.example.onlinetoursapp.feature.presenter.HotelView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class HotelFragment : MvpAppCompatFragment(), HotelView {

    private var _binding: FragmentHotelBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    @Inject
    lateinit var presenterProvider: Provider<HotelPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    private lateinit var hotelAdapter: HotelAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        SearchHolder.createComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHotelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }

    private fun setupRecycler() {
        hotelAdapter = HotelAdapter()
        binding.recycler.adapter = hotelAdapter
    }

    override fun loadHotelData(hotelData: List<HotelData>) {
        hotelAdapter.submitList(hotelData)
    }

}