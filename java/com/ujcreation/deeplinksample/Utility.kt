package com.ujcreation.deeplinksample

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Umesh on 4/5/2018.
 */
class Utility {
    companion object {
        fun isInternetAvailable(context: Context
        ): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }
    }
}