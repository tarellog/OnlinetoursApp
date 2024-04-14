package com.example.onlinetoursapp.feature.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.navArgs
import com.example.onlinetoursapp.common.extensions.hideKeyboard
import com.example.onlinetoursapp.databinding.DialogSearchFromBinding
import com.example.onlinetoursapp.feature.adapter.search.CitiesAdapter
import com.example.onlinetoursapp.feature.adapter.search.RegionsAdapter
import com.example.onlinetoursapp.feature.di.SearchHolder
import com.example.onlinetoursapp.feature.domain.model.CitiesData
import com.example.onlinetoursapp.feature.domain.model.RegionsData
import com.example.onlinetoursapp.feature.presenter.SearchPresenter
import com.example.onlinetoursapp.feature.presenter.SearchView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import moxy.MvpBottomSheetDialogFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class SearchFromDialog : MvpBottomSheetDialogFragment(), SearchView {

    private var _binding: DialogSearchFromBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    private val args: SearchFromDialogArgs by navArgs()

    @Inject
    lateinit var dialogPresenterProvider: Provider<SearchPresenter>
    private val presenter by moxyPresenter { dialogPresenterProvider.get() }

    private lateinit var citiesAdapter: CitiesAdapter
    private lateinit var regionsAdapter: RegionsAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        SearchHolder.createComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogSearchFromBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        clearFocus()
        setupSearchInputField()
        setupCancelButton()
        stateDialog()
        setupSearchType()
    }

    private fun setupRecycler() {
        if (args.searchType) {
            citiesAdapter = CitiesAdapter(presenter::onClickItemByCity)
            binding.recycler.adapter = citiesAdapter
        } else {
            regionsAdapter = RegionsAdapter(presenter::onClickItemByRegion)
            binding.recycler.adapter = regionsAdapter
        }
    }

    private fun clearFocus() {
        binding.inputField.setOnEditorActionListener { _, actionId, _ ->
            binding.inputField.hideKeyboard()
            binding.inputField.clearFocus()
            false
        }
    }

    private fun setupSearchInputField() {
        binding.inputField.addTextChangedListener {
            presenter.onChangeListener(it.toString())
        }
    }

    private fun setupCancelButton() {
        binding.cansel.setOnClickListener { dismiss() }
    }

    private fun stateDialog() {
        this.dialog?.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            val frameLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            val bottomSheetBehavior = BottomSheetBehavior.from(frameLayout)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
        binding.inputField.requestFocus()
    }

    private fun setupSearchType() {
        presenter.typeSearch(args.searchType)
    }

    override fun loadCitiesData(list: List<CitiesData>) {
        citiesAdapter.submitList(list)
    }

    override fun loadRegionData(list: List<RegionsData>) {
        regionsAdapter.submitList(list)
    }

    override fun onDismiss() {
        dismiss()
    }

}