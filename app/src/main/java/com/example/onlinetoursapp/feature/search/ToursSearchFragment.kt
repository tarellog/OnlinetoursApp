package com.example.onlinetoursapp.feature.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlinetoursapp.common.application.appComponent
import com.example.onlinetoursapp.common.viewmodelfactory.assistedViewModel
import com.example.onlinetoursapp.databinding.FragmentToursSearchBinding
import com.example.onlinetoursapp.feature.search.di.DaggerSearchComponent
import javax.inject.Inject

class ToursSearchFragment : Fragment() {

    private var _binding: FragmentToursSearchBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    @Inject
    lateinit var factory: ToursSearchViewModel.Factory
    private val viewModel by assistedViewModel { factory.create() }

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
        viewModel.okey()
    }

}