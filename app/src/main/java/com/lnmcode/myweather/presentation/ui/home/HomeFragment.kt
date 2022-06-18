package com.lnmcode.myweather.presentation.ui.home

import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import androidx.core.location.LocationManagerCompat
import com.google.android.material.snackbar.Snackbar
import com.lnmcode.myweather.R
import com.lnmcode.myweather.databinding.FragmentHomeBinding
import com.lnmcode.myweather.presentation.base.BaseFragment
import com.lnmcode.myweather.presentation.ui.home.HomeEvents.InsertOrUpdateCurrentLocation
import com.lnmcode.myweather.presentation.ui.home_weather.LocationTrigger
import com.lnmcode.myweather.utils.DialogUtils
import com.lnmcode.myweather.utils.LocationUtils.locationUpdatesChanged
import com.lnmcode.myweather.utils.PermissionUtils
import com.lnmcode.myweather.utils.PermissionUtils.arePermissionGranted
import com.lnmcode.myweather.utils.PermissionUtils.locationPermission
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModel()

    private val dialogMultiplePermissionListener by lazy {
        PermissionUtils.DialogMultiplePermissionListener(
            view = requireView(),
            onPermissionGranted = { onPermissionGranted() },
            onPermissionDenied = { onPermissionDenied() }
        )
    }

    private lateinit var locationManager: LocationManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configUIPermission()
    }

    override fun setUpLayout() {
        setUpSlideViewPager()
        binding {
            vm = viewModel
            viewpager = binding.vpHome
        }
    }

    override fun setUpEvents() {
    }

    private fun setUpSlideViewPager() {
        // Init slide pager adapter
        var adapter = HomeSlidePagerAdapter(this, 1)
        binding.vpHome.adapter = adapter
        // update view by livedata
        viewModel.numberItemCount.observe(viewLifecycleOwner) { number ->
            adapter = HomeSlidePagerAdapter(this, number)
            binding.vpHome.adapter = adapter
            binding.navBottom.dotsIndicator.attachTo(binding.vpHome)
        }
    }

    private fun configUIPermission() {
        if (arePermissionGranted(requireContext(), locationPermission)) {
            onPermissionGranted()
        } else {
            requestPermission()
        }
    }

    private fun startLocationService() {
        locationUpdatesChanged(locationManager) {
            insertOrUpdateCurrentLocation(it)
        }
    }

    private fun insertOrUpdateCurrentLocation(locationTrigger: LocationTrigger) {
        viewModel.onTriggerEvents(InsertOrUpdateCurrentLocation(locationTrigger))
    }

    private fun isLocationEnabled(): Boolean {
        locationManager = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return LocationManagerCompat.isLocationEnabled(locationManager)
    }

    private fun requestPermission() {
        PermissionUtils.requestPermissions(
            requireContext(),
            dialogMultiplePermissionListener,
            locationPermission
        )
    }

    private fun onPermissionGranted() {
        if (isLocationEnabled()) {
            startLocationService()
        } else {
            Timber.d("Location service disabled")
            DialogUtils.showDialog(requireActivity())
        }
    }

    private fun onPermissionDenied() {
        Snackbar.make(requireView(), "Permission denied", Snackbar.LENGTH_LONG).show()
    }

}