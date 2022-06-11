package com.lnmcode.myweather.presentation.ui.home

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.lnmcode.myweather.R
import com.lnmcode.myweather.databinding.FragmentHomeBinding
import com.lnmcode.myweather.presentation.base.BaseFragment
import com.lnmcode.myweather.presentation.ui.home.HomeEvents.InsertLocation
import com.lnmcode.myweather.presentation.ui.home_weather.LocationTrigger
import com.lnmcode.myweather.utils.LocationUtils.createLocationCallback
import com.lnmcode.myweather.utils.LocationUtils.createLocationRequest
import com.lnmcode.myweather.utils.LocationUtils.removeLocationServiceProvider
import com.lnmcode.myweather.utils.LocationUtils.startLocationServiceProvider
import com.lnmcode.myweather.utils.PermissionUtils
import com.lnmcode.myweather.utils.PermissionUtils.arePermissionGranted
import com.lnmcode.myweather.utils.PermissionUtils.locationPermission
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModel()

    private val dialogMultiplePermissionListener by lazy {
        PermissionUtils.DialogMultiplePermissionListener(
            view = requireView(),
            onPermissionGranted = { onPermissionGranted() },
            onPermissionDenied = { onPermissionDenied() }
        )
    }

    private val locationCallBack by lazy { createLocationCallback { locationCallbackTrigger(it) } }

    private val locationRequest by lazy { createLocationRequest() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configUIPermission()
    }

    override fun setUpLayout() {
        setUpSlideViewPager()
    }

    override fun setUpEvents() {
    }

    private fun setUpSlideViewPager() {
        val slideAdapter = HomeSlidePagerAdapter(this)
        binding.vpHome.adapter = slideAdapter
    }

    private fun configUIPermission() {
        if (arePermissionGranted(requireContext(), locationPermission)) {
            onPermissionGranted()
        } else {
            requestPermission()
        }
    }

    private fun startLocationService() {
        startLocationServiceProvider(
            context = requireContext(),
            locationRequest = locationRequest,
            locationCallback = locationCallBack
        )
    }

    private fun removeLocationService() {
        removeLocationServiceProvider(
            context = requireContext(),
            locationCallback = locationCallBack
        )
    }

    private fun locationCallbackTrigger(locationTrigger: LocationTrigger) {
        viewModel.onTriggerEvents(InsertLocation(locationTrigger))
    }

    private fun requestPermission() {
        PermissionUtils.requestPermissions(
            requireContext(),
            dialogMultiplePermissionListener,
            locationPermission
        )
    }

    private fun onPermissionGranted() {
        startLocationService()
    }

    private fun onPermissionDenied() {
        Snackbar.make(requireView(), "Permission denied", Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        removeLocationService()
    }

}