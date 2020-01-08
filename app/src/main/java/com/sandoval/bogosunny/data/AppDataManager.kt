package com.sandoval.bogosunny.data

import com.sandoval.bogosunny.data.db.AppDbHelper
import com.sandoval.bogosunny.data.db.room.model.City
import com.sandoval.bogosunny.data.network.model.forecast.Forecast
import com.sandoval.bogosunny.data.network.model.weather.CurrentWeather
import io.reactivex.Observable
import javax.inject.Inject

class AppDataManager @Inject
constructor(
    private val appDbHelper: AppDbHelper,
    private val appApiHelper: AppApiHelper
) : DataManager {
    override fun getCurrentLocationWeather(
        lat: String,
        lon: String,
        appId: String,
        units: String
    ): Observable<CurrentWeather> {
        return appApiHelper.getCurrentLocationWeather(lat, lon, appId, units)
    }

    override fun getCityWeather(
        cityName: String,
        appId: String,
        units: String
    ): Observable<CurrentWeather> {
        return appApiHelper.getCityWeather(cityName, appId, units)
    }

    override fun getCurrentLocationForecast(
        lat: String,
        lon: String,
        appId: String,
        units: String,
        count: String
    ): Observable<Forecast> {
        return appApiHelper.getCurrentLocationForecast(lat, lon, appId, units, count)
    }

    override fun getCityForecast(
        cityName: String,
        appId: String,
        units: String,
        count: String
    ): Observable<Forecast> {
        return appApiHelper.getCityForecast(cityName, appId, units, count)
    }

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