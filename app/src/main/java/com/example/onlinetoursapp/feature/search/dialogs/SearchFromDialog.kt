package com.example.onlinetoursapp.feature.search.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.setFragmentResult
import com.example.onlinetoursapp.common.application.appComponent
import com.example.onlinetoursapp.databinding.DialogSearchFromBinding
import com.example.onlinetoursapp.feature.search.adapter.SearchAdapter
import com.example.onlinetoursapp.feature.search.di.DaggerSearchComponent
import com.example.onlinetoursapp.feature.search.domain.model.CitiesData
import com.example.onlinetoursapp.feature.search.presenter.SearchPresenter
import com.example.onlinetoursapp.feature.search.presenter.SearchView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import moxy.MvpBottomSheetDialogFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class SearchFromDialog : MvpBottomSheetDialogFragment(), SearchView {

    private var _binding: DialogSearchFromBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    @Inject
    lateinit var presenterProvider: Provider<SearchPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    private lateinit var searchAdapter: SearchAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerSearchComponent.factory().create(context.appComponent).inject(this)
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
    }

    private fun setupRecycler() {
        searchAdapter = SearchAdapter(presenter::onClickItem)
        binding.recycler.adapter = searchAdapter
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

    override fun loadCitiesData(list: List<CitiesData>) {
        searchAdapter.submitList(list)
    }

    override fun onDismiss(city: String, departCityId: Int) {
        dismiss()
        setFragmentResult(
            SEARCH_DIALOG,
            bundleOf(
                BUNDLE_SEARCH to city,
                BUNDLE_SEARCH_ID to departCityId
            )
        )
    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    companion object {
        const val SEARCH_DIALOG = "SEARCH_DIALOG"
        const val BUNDLE_SEARCH = "BUNDLE_SEARCH"
        const val BUNDLE_SEARCH_ID = "BUNDLE_SEARCH_ID"
    }
}