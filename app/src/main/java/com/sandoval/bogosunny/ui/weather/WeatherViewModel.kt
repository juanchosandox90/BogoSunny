package com.sandoval.bogosunny.ui.weather

import androidx.lifecycle.ViewModel
import com.sandoval.bogosunny.data.DataManager
import com.sandoval.bogosunny.data.db.room.model.City
import javax.inject.Inject

class WeatherViewModel @Inject
constructor(
    private val dataManager: DataManager
) : ViewModel() {
    fun getSavedCities(): List<City> {
        return dataManager.getCities()
    }
}