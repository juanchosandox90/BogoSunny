package com.sandoval.bogosunny.data.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sandoval.bogosunny.data.db.room.model.City

@Dao
interface CityDao {

    @Query("DELETE FROM cities WHERE city_name =:city ")
    fun deleteCyty(city: String): Int

    @Insert
    fun insertCity(city: City): Long

    @Query("SELECT * FROM cities")
    fun getCities(): List<City>
}