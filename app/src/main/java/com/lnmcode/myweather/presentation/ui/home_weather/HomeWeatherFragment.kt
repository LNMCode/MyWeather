package com.lnmcode.myweather.presentation.ui.home_weather

import com.lnmcode.myweather.R
import com.lnmcode.myweather.databinding.FragmentHomeWeatherBinding
import com.lnmcode.myweather.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeWeatherFragment(
    private val idLocation: Int,
) : BaseFragment<FragmentHomeWeatherBinding>(R.layout.fragment_home_weather) {

    override val viewModel: HomeWeatherViewModel by viewModel()

    override fun setUpLayout() {
        binding.vm = viewModel
    }

    override fun setUpEvents() {
        viewModel.onTriggerEvents(HomeWeatherEvents.GetListLocation(idLocation))
    }
}