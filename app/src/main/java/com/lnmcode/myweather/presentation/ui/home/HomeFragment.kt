package com.lnmcode.myweather.presentation.ui.home

import android.os.Bundle
import android.view.View
import com.lnmcode.myweather.R
import com.lnmcode.myweather.databinding.FragmentHomeBinding
import com.lnmcode.myweather.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun setUpLayout() {
    }

    override fun setUpEvents() {
        binding.haha.setOnClickListener {
            Timber.d("Request")
            viewModel.getWeather()
        }
    }

}