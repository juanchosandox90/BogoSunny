package com.sandoval.bogosunny.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sandoval.bogosunny.data.db.room.model.City


@Database(entities = [City::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun cityDao(): CityDao
}