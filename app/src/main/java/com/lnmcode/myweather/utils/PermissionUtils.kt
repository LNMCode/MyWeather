package com.lnmcode.myweather.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.view.View
import androidx.core.content.ContextCompat
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import timber.log.Timber

object PermissionUtils {

    val locationPermission = listOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
    )

    fun isPermissionGranted(context: Context, permission: String) =
        ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED

    fun arePermissionGranted(context: Context, permissions: Collection<String>) =
        permissions.all { permission -> isPermissionGranted(context, permission) }

    fun requestPermissions(
        context: Context,
        listener: MultiplePermissionsListener,
        permissions: Collection<String>
    ) {
        Dexter.withContext(context)
            .withPermissions(permissions)
            .withListener(listener)
            .withErrorListener {
                Timber.e(it.toString())
            }
            .check()
    }

    class DialogMultiplePermissionListener(
        val view: View,
        val onPermissionGranted: () -> Unit,
        val onPermissionDenied: () -> Unit
    ) : BaseMultiplePermissionsListener() {
        val context: Context = view.context

        override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
            Timber.d("it.areAllPermissionsGranted() is ${report?.areAllPermissionsGranted()} and permissions denied is ${report?.deniedPermissionResponses}")
            if (report?.areAllPermissionsGranted() == true) {
                onPermissionGranted()
            } else {
                onPermissionDenied()
            }
        }
    }

}