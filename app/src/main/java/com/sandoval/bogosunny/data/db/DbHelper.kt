package com.sandoval.bogosunny.data.db

import com.sandoval.bogosunny.data.db.room.model.City

interface DbHelper {
    fun deleteCity(city: String): Int

    fun insertCity(city: City): Long

    fun getCities(): List<City>
}