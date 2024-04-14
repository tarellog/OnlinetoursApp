package com.example.onlinetoursapp.feature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.onlinetoursapp.R
import com.example.onlinetoursapp.databinding.FragmentToursSearchBinding
import com.example.onlinetoursapp.feature.di.SearchHolder
import com.example.onlinetoursapp.feature.domain.model.SearchFrom
import com.example.onlinetoursapp.feature.domain.model.SearchTo
import com.example.onlinetoursapp.feature.presenter.ToursSearchPresenter
import com.example.onlinetoursapp.feature.presenter.ToursSearchView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class ToursSearchFragment : MvpAppCompatFragment(), ToursSearchView {

    private var _binding: FragmentToursSearchBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    @Inject
    lateinit var presenterProvider: Provider<ToursSearchPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    private var typeSearch = true

    override fun onAttach(context: Context) {
        super.onAttach(context)
        SearchHolder.createComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToursSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickButton()
        setClickSearchFrom()
        setClickSearchTo()
    }

    override fun setDataByTypeSearch(searchFrom: SearchFrom, searchTo: SearchTo) {
        binding.searchFrom.text = searchFrom.cityName ?: "Откуда"
        binding.searchFrom.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        binding.searchTo.text = searchTo.regionName ?: "Куда"
        binding.searchTo.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
    }

    private fun setClickButton() {
        binding.search.setOnClickListener {
            val action =
                ToursSearchFragmentDirections.actionGlobalHotelNavGraph()
            findNavController().navigate(action)
        }
    }

    private fun setClickSearchFrom() {
        binding.searchFrom.setOnClickListener {
            typeSearch = true
            val action =
                ToursSearchFragmentDirections.actionToursSearchFragmentToSearchFromDialog(
                    typeSearch
                )
            findNavController().navigate(action)
        }
    }

    private fun setClickSearchTo() {
        binding.searchTo.setOnClickListener {
            typeSearch = false
            val action =
                ToursSearchFragmentDirections.actionToursSearchFragmentToSearchFromDialog(
                    typeSearch
                )
            findNavController().navigate(action)
        }
    }

}