package com.sandoval.bogosunny.ui.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sandoval.bogosunny.ui.base.BaseActivity

abstract class BaseFragment : Fragment() {

    private var baseActivity: BaseActivity? = null
    private var progressDialog: Dialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            baseActivity = context
        }
    }

    protected abstract fun setUp(view: View)

    fun showLoading() {
        //TODO: Show loading using utils tools
    }

    fun hideLoading() {
        //TODO: Hide loading using utils tools
    }

    fun showMessage(message: String?) {
        //TODO: Show message message using baseActivity
    }

    fun showError(message: String?) {
        //TODO: Show Error message using baseActivity
    }

    fun getBaseActivity(): BaseActivity? {
        return baseActivity
    }
}