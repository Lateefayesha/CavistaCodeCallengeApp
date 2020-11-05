package com.appynitty.permissionapplication.permission

import com.karumi.dexter.listener.DexterError

/**
 * Created by Ayan Dey on 1/10/20.
 */
interface PermissionListener {
fun onPermissionGranted(permissionName:String)
    fun onPermissionDenied(permissionName: String)
}