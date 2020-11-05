package com.appynitty.permissionapplication.permission


import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener


/**
 * Created by Ayan Dey on 1/10/20.
 */
 class MultiplePermissionListener (val activity: CheckPermissionListener): MultiplePermissionsListener {



    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
        for (response in report!!.grantedPermissionResponses) {
            activity.showPermissionGranted(response.permissionName)
        }



        for (response in report.deniedPermissionResponses) {
            activity.showPermissionDenied(
                response.permissionName,
                response.isPermanentlyDenied
            )
        }
    }


    override fun onPermissionRationaleShouldBeShown(
        permissions: MutableList<PermissionRequest>?,
        token: PermissionToken?
    ) {
        activity.showPermissionRationale(token);
    }
}


