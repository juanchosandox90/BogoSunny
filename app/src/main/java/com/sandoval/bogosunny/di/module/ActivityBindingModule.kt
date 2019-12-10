package com.sandoval.bogosunny.di.module

import com.sandoval.bogosunny.ui.weather.WeatherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun bindWeatherActivity(): WeatherActivity
}