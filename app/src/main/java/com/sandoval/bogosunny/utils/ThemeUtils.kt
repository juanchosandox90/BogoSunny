package com.sandoval.bogosunny.utils

import android.content.res.Resources
import com.sandoval.bogosunny.R
import java.util.*

object ThemeUtils {
    fun getTheme(theme: Resources.Theme): Resources.Theme {
        val cal = Calendar.getInstance()
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        if (hour <= 6 || hour >= 18) {
            theme.applyStyle(R.style.AppThemeNight, true)
        }
        return theme
    }

    fun isNight(): Boolean {
        val cal = Calendar.getInstance()
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        return hour <= 6 || hour >= 18
    }
}