package com.sandoval.bogosunny.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sandoval.bogosunny.ViewModelFactory
import com.sandoval.bogosunny.di.ViewModelKey
import com.sandoval.bogosunny.ui.add_city.AddCityViewModel
import com.sandoval.bogosunny.ui.saved_cities.SavedCitiesViewModel
import com.sandoval.bogosunny.ui.weather.currentLocation.CurrentLocationWeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AddCityViewModel::class)
    internal abstract fun postAddCityViewModel(addCityViewModel: AddCityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SavedCitiesViewModel::class)
    internal abstract fun postSavedCitiesViewModel(savedCitiesViewModel: SavedCitiesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CurrentLocationWeatherViewModel::class)
    internal abstract fun postCurrentLocationWeatherViewModel(currentLocationWeatherViewModel: CurrentLocationWeatherViewModel): ViewModel
}