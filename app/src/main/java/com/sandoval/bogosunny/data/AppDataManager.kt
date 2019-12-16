package com.sandoval.bogosunny.data

import com.sandoval.bogosunny.data.db.AppDbHelper
import com.sandoval.bogosunny.data.db.room.model.City
import javax.inject.Inject

class AppDataManager @Inject
constructor(
    private val appDbHelper: AppDbHelper
) : DataManager {
    override fun deleteCity(city: String): Int {
        return appDbHelper.deleteCity(city)
    }

    override fun insertCity(city: City): Long {
        return appDbHelper.insertCity(city)
    }

    override fun getCities(): List<City> {
        return appDbHelper.getCities()
    }

}