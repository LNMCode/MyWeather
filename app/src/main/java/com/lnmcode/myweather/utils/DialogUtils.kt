package com.lnmcode.myweather.utils

import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import com.lnmcode.myweather.R

object DialogUtils {

    fun showDialog(context: Context) {
        AlertDialog.Builder(context)
            .setMessage(R.string.dialog_message_turn_on_location_service)
            .setPositiveButton(R.string.dialog_button_cancel) { dialog, which ->
                dialog.dismiss()
            }
            .setNegativeButton(R.string.dialog_button_ok) { dialog, which ->
                context.startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }.create().show()
    }
}