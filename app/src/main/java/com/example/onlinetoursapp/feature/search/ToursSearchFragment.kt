package com.example.onlinetoursapp.feature.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.onlinetoursapp.R
import com.example.onlinetoursapp.common.application.appComponent
import com.example.onlinetoursapp.databinding.FragmentToursSearchBinding
import com.example.onlinetoursapp.feature.search.di.DaggerSearchComponent
import com.example.onlinetoursapp.feature.search.dialogs.SearchFromDialog.Companion.BUNDLE_CITIES_ID
import com.example.onlinetoursapp.feature.search.dialogs.SearchFromDialog.Companion.BUNDLE_REGION_ID
import com.example.onlinetoursapp.feature.search.dialogs.SearchFromDialog.Companion.BUNDLE_SEARCH
import com.example.onlinetoursapp.feature.search.dialogs.SearchFromDialog.Companion.SEARCH_DIALOG
import com.example.onlinetoursapp.feature.search.presenter.ToursSearchPresenter
import com.example.onlinetoursapp.feature.search.presenter.ToursSearchView
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
        DaggerSearchComponent.factory().create(context.appComponent).inject(this)
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
        test()
        setupButton()
        openSearchFromDialog()
        openSearchToDialog()
    }

    private fun test() {
        setFragmentResultListener(SEARCH_DIALOG) { _, bundle ->
            val search = bundle.getString(BUNDLE_SEARCH)
            val departCityId = bundle.getInt(BUNDLE_CITIES_ID)
            val regionId = bundle.getInt(BUNDLE_REGION_ID)
            if (typeSearch) binding.searchFrom.text = search
            else binding.searchTo.text = search
            binding.searchFrom.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            binding.searchTo.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            if (typeSearch) presenter.setCityId(departCityId)
            else presenter.setRegionId(regionId)
        }
    }

    private fun setupButton() {
        binding.search.setOnClickListener {
            presenter.okey()
        }
    }

    private fun openSearchFromDialog() {
        binding.searchFrom.setOnClickListener {
            typeSearch = true
            val action =
                ToursSearchFragmentDirections.actionToursSearchFragmentToSearchFromDialog(typeSearch)
            findNavController().navigate(action)
        }
    }

    private fun openSearchToDialog() {
        binding.searchTo.setOnClickListener {
            typeSearch = false
            val action =
                ToursSearchFragmentDirections.actionToursSearchFragmentToSearchFromDialog(typeSearch)
            findNavController().navigate(action)
        }
    }

}