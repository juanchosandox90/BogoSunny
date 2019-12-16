package com.sandoval.bogosunny.ui.add_city

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.sandoval.bogosunny.R
import com.sandoval.bogosunny.ui.base.BaseActivity

class AddCityActivity : BaseActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, AddCityActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_city)
    }
}