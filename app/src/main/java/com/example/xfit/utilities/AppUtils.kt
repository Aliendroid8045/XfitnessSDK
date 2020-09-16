package com.example.xfit.utilities

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkInfo

class AppUtils {

    companion object {
        fun isOnline(context: Context): Boolean {
            val connMgr = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo: NetworkInfo? = connMgr.activeNetworkInfo
            return networkInfo?.isConnected == true
        }

        fun calculateNoOfColumns(context: Context, columnWidthDp: Float): Int {
            val displayMetrics = context.resources.displayMetrics;
            val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
            return ((screenWidthDp / columnWidthDp + 0.5).toInt())
        }
    }

}