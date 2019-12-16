package com.sandoval.bogosunny.data.db

import com.sandoval.bogosunny.data.db.room.AppDataBase
import com.sandoval.bogosunny.data.db.room.model.City
import javax.inject.Inject

class AppDbHelper @Inject
constructor(private val appDataBase: AppDataBase) : DbHelper {
    override fun deleteCity(city: String): Int {
        return appDataBase.cityDao().deleteCyty(city)
    }

    override fun insertCity(city: City): Long {
        return appDataBase.cityDao().insertCity(city)
    }

    override fun getCities(): List<City> {
        return appDataBase.cityDao().getCities()
    }

}