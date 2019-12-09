package com.sandoval.bogosunny

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import com.sandoval.bogosunny.ui.BaseActivity
import com.sandoval.bogosunny.utils.ThemeUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.toolbar

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        if (ThemeUtils.isNight())
            changeRings()
    }

    private fun changeRings() {
        rings.setBackgroundResource(R.drawable.circular_rings_dark)
        sun_and_moon.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FFFFFF"))
        add_city_button.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#403C48"))

    }
}
