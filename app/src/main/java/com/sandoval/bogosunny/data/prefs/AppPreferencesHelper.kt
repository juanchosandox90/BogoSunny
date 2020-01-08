package com.sandoval.bogosunny.data.prefs

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.sandoval.bogosunny.di.ApplicationContext
import com.sandoval.bogosunny.utils.AppConstants.CITY
import javax.inject.Inject

class AppPreferencesHelper @Inject constructor(@ApplicationContext context: Context) :
    PreferencesHelper {

    private val sharedPreferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    override fun setCity(city: String) {
        sharedPreferences.edit().putString(CITY, city).apply()
    }

    override fun getCity(): String? {
        return sharedPreferences.getString(CITY, "")
    }

}