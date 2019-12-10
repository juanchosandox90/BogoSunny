package com.sandoval.bogosunny.ui.weather

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import com.sandoval.bogosunny.R
import com.sandoval.bogosunny.ui.base.BaseActivity
import com.sandoval.bogosunny.utils.ThemeUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.toolbar

class WeatherActivity : BaseActivity() {

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
        animateSunAndMoon()
    }

    private fun changeRings() {
        rings.setBackgroundResource(R.drawable.circular_rings_dark)
        sun_and_moon.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FFFFFF"))
        add_city_button.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#403C48"))
    }

    private fun animateSunAndMoon() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels

        val animation = ObjectAnimator.ofFloat(sun_and_moon, "translationX", width.toFloat())
        animation.duration = 5000
        animation.repeatCount = ValueAnimator.INFINITE
        animation.repeatMode = ValueAnimator.REVERSE
        animation.start()
    }
}
