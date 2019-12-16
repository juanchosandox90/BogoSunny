package com.sandoval.bogosunny.di.module

import com.sandoval.bogosunny.ui.add_city.AddCityActivity
import com.sandoval.bogosunny.ui.add_city.AddCityModule
import com.sandoval.bogosunny.ui.saved_cities.SavedCitiesActivity
import com.sandoval.bogosunny.ui.saved_cities.SavedCitiesModule
import com.sandoval.bogosunny.ui.weather.WeatherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun bindWeatherActivity(): WeatherActivity

    @ContributesAndroidInjector(modules = [(AddCityModule::class)])
    abstract fun bindAddCityActivity(): AddCityActivity

    @ContributesAndroidInjector(modules = [(SavedCitiesModule::class)])
    abstract fun bindSavedCitiesActivity(): SavedCitiesActivity
}