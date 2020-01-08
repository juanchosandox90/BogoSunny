package com.sandoval.bogosunny.ui.saved_cities

import androidx.lifecycle.ViewModel
import com.sandoval.bogosunny.data.DataManager
import com.sandoval.bogosunny.data.db.room.model.City
import javax.inject.Inject

class SavedCitiesViewModel @Inject
constructor(
    private val dataManager: DataManager
) : ViewModel() {
    fun getSavedCities(): List<City> {
        return dataManager.getCities()
    }

    fun removeCity(city: String): Int {
        return dataManager.deleteCity(city)
    }
}