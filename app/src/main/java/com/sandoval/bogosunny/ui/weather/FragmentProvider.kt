package com.sandoval.bogosunny.ui.weather

import com.sandoval.bogosunny.ui.weather.city.CityWeatherFragment
import com.sandoval.bogosunny.ui.weather.currentLocation.CurrentLocationWeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {
    @ContributesAndroidInjector
    internal abstract fun provideCurrentLocationWeatherFragment(): CurrentLocationWeatherFragment

    @ContributesAndroidInjector
    internal abstract fun provideCityWeatherModuleFragment(): CityWeatherFragment
}