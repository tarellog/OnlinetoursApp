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
import com.example.onlinetoursapp.feature.search.dialogs.SearchFromDialog.Companion.BUNDLE_SEARCH
import com.example.onlinetoursapp.feature.search.dialogs.SearchFromDialog.Companion.BUNDLE_SEARCH_ID
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
        openSearchFromDialog()

    }

    private fun test() {
        setFragmentResultListener(SEARCH_DIALOG) { _, bundle ->
            val search = bundle.getString(BUNDLE_SEARCH)
            val departCityId = bundle.getInt(BUNDLE_SEARCH_ID)
            binding.searchFrom.text = search
            binding.searchFrom.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            presenter.setCityId(departCityId)
        }
    }

    private fun openSearchFromDialog() {
        binding.searchFrom.setOnClickListener {
            findNavController().navigate(R.id.action_toursSearchFragment_to_searchFromDialog)
        }
    }

    private fun openSearchToDialog() {
        binding.searchTo.setOnClickListener {
            findNavController().navigate(R.id.action_toursSearchFragment_to_searchFromDialog)
        }
    }

}