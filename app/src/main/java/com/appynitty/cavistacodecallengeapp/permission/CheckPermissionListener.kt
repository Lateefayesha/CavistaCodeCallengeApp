package com.appynitty.permissionapplication.permission

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.appynitty.cavistacodecallengeapp.R
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.CompositeMultiplePermissionsListener
import com.karumi.dexter.listener.multi.SnackbarOnAnyDeniedMultiplePermissionsListener

/**
 * Created by Ayan Dey on 1/10/20.
 */
class CheckPermissionListener(private val activity: Context, private val text: TextView, private val permissionCollections:List<String>, private val permissionListener: PermissionListener) {

    private var allPermissionsListener: CompositeMultiplePermissionsListener? = null
    private var errorListener: ErrorListener? = null
    private var multiplePermissionListener: MultiplePermissionListener? = null


//    internal fun checkPermissionFirst() {
//
//        Dexter.withContext(activity)
//            .withPermissions(
//                Manifest.permission.CAMERA,
//                Manifest.permission.READ_EXTERNAL_STORAGE,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.ACCESS_COARSE_LOCATION,
//                Manifest.permission.READ_CONTACTS,
//                Manifest.permission.WRITE_CONTACTS
//            )
//            .withListener(allPermissionsListener)
//            .withErrorListener(errorListener)
//            .check();
//    }

    internal fun checkPermissionFirst() {

        Dexter.withContext(activity)

            .withPermissions(permissionCollections)
            .withListener(allPermissionsListener)
            .withErrorListener(errorListener)
            .check();
    }

    internal fun createPermissionListener() {
        multiplePermissionListener = MultiplePermissionListener(this)

        errorListener = ErrorListener()




        allPermissionsListener = CompositeMultiplePermissionsListener(
            multiplePermissionListener,
            SnackbarOnAnyDeniedMultiplePermissionsListener.Builder.with(
                text,
                activity.getString(R.string.all_permissions_denied_feedback)
            )
                .withOpenSettingsButton(activity.getString(R.string.permission_rationale_settings_button_text))
                .build()
        )

    }

    internal fun showPermissionGranted(permissionName: String?) {
        Log.d(TAG, "showPermissionGranted: ${permissionName}")
        text.setText(permissionName?.let { getFeedbackViewForPermission(it) })

        permissionName?.let { permissionListener.onPermissionGranted(it) }

    }

    internal  fun showPermissionDenied(permissionName: String?, isPermanentlyDenied: Boolean) {
        if(isPermanentlyDenied){
            Log.d(TAG, "showPermissionDenied Permanent: ${permissionName}" )
            permissionName?.let { permissionListener.onPermissionDenied(it) }

        }else{
            Log.d(TAG, "showPermissionDenied: ${permissionName}" )
            permissionName?.let { permissionListener.onPermissionDenied(it) }


        }

//        val feedbackView: TextView? = getFeedbackViewForPermission(permission)
//        feedbackView.setText(if (isPermanentlyDenied) R.string.permission_permanently_denied_feedback else R.string.permission_denied_feedback)
//        feedbackView!!.setTextColor(ContextCompat.getColor(this, R.color.permission_denied))
    }

    internal  fun showPermissionRationale(token: PermissionToken?) {
        AlertDialog.Builder(activity).setTitle(activity.getString(R.string.permission_rationale_title))
            .setMessage(activity.getString(R.string.permission_rationale_title))
            .setNegativeButton("cancel"
            ) { dialog, which ->
                dialog.dismiss()
                token!!.cancelPermissionRequest()
            }
            .setPositiveButton("ok"
            ) { dialog, which ->
                dialog.dismiss()
                token!!.continuePermissionRequest()
            }
            .setOnDismissListener(DialogInterface.OnDismissListener { token!!.cancelPermissionRequest() })
            .show()

    }


    private fun getFeedbackViewForPermission(name: String): String? {
        var feedbackView: String= ""
        when (name) {
            Manifest.permission.CAMERA -> {feedbackView="Camera"}
            Manifest.permission.READ_EXTERNAL_STORAGE -> {feedbackView="Read Storage"}
            Manifest.permission.WRITE_EXTERNAL_STORAGE -> {feedbackView="External Storage"}
            Manifest.permission.ACCESS_FINE_LOCATION -> {feedbackView="ACCESS_FINE_LOCATION"}
            Manifest.permission.ACCESS_COARSE_LOCATION -> {feedbackView="ACCESS_COARSE_LOCATION"}
            Manifest.permission.READ_CONTACTS -> {feedbackView="READ_CONTACTS"}
            Manifest.permission.WRITE_CONTACTS -> {feedbackView="WRITE_CONTACTS"}


            else -> throw RuntimeException("No feedback view for this permission")
        }

        return feedbackView
    }

    companion object {
        private const val TAG = "CheckPermissionListener"
    }
}