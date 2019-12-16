package com.sandoval.bogosunny.ui.add_city

import androidx.lifecycle.ViewModel
import com.sandoval.bogosunny.data.DataManager
import com.sandoval.bogosunny.data.db.room.model.City
import javax.inject.Inject

class AddCityViewModel @Inject
constructor(
    private val dataManager: DataManager
) : ViewModel() {
    fun addCity(city: String): Long {
        return dataManager.insertCity(City(cityName = city))
    }
}