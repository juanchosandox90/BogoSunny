package com.sandoval.bogosunny.ui.base

import android.app.Dialog
import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Build
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.sandoval.bogosunny.utils.CommonUtils
import com.sandoval.bogosunny.utils.ThemeUtils

open class BaseActivity : AppCompatActivity() {
    private var progressDialog: Dialog? = null

    override fun getTheme(): Resources.Theme {
        val theme = super.getTheme()
        return ThemeUtils.getTheme(theme)
    }

    fun hasPermissions(permissions: Array<String>): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true
        return permissions.none {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }
    }

    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    fun showLoading() {
        hideLoading()
        progressDialog = CommonUtils.showLoadingDialog(this)
    }

    fun hideLoading() {
        if (progressDialog != null) {
            if (progressDialog?.isShowing == true)
                progressDialog?.cancel()
        }
    }
}