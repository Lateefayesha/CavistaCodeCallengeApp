package com.appynitty.permissionapplication.permission

import android.util.Log
import com.karumi.dexter.listener.DexterError
import com.karumi.dexter.listener.PermissionRequestErrorListener

/**
 * Created by Ayan Dey on 1/10/20.
 */
class ErrorListener : PermissionRequestErrorListener {
    override fun onError(error: DexterError?) {
        Log.e("Dexter", "There was an error: " + error.toString());
    }
}