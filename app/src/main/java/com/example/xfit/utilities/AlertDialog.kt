package com.example.xfit.utilities

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.example.xfit.R

class AlertDialog {
    fun displayTwoButtonDialog(context: Context, title: String, message: String) {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setTitle(title)
        dialogBuilder.setMessage(message)
        dialogBuilder.setPositiveButton("OK", DialogInterface.OnClickListener(positiveButtonClick))
        dialogBuilder.show().window?.setBackgroundDrawableResource(R.drawable.button_background)
    }

    private val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        dialog.dismiss()
    }


     fun networkAlertError(context: Context) {
        val alert = AlertDialog()
        alert.displayTwoButtonDialog(
            context,
            context.getString(R.string.no_internet),
            context.getString(R.string.no_internet_error)
        )
    }

}