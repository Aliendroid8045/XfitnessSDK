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

    }
}