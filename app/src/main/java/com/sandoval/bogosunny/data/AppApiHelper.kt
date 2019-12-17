package com.sandoval.bogosunny.data

import com.sandoval.bogosunny.data.network.ApiHelper
import com.sandoval.bogosunny.data.network.ApiService
import com.sandoval.bogosunny.data.network.model.forecast.Forecast
import com.sandoval.bogosunny.data.network.model.weather.CurrentWeather
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject
constructor(
    private val apiService: ApiService
) : ApiHelper {
    override fun getCurrentLocationWeather(
        lat: String,
        lon: String,
        appId: String,
        units: String
    ): Observable<CurrentWeather> {
        return apiService.getCurrentLocationWeather(lat, lon, appId, units)
    }

    override fun getCityWeather(
        cityName: String,
        appId: String,
        units: String
    ): Observable<CurrentWeather> {
        return apiService.getCityWeather(cityName, appId, units)
    }

    override fun getCurrentLocationForecast(
        lat: String,
        lon: String,
        appId: String,
        units: String,
        count: String
    ): Observable<Forecast> {
        return apiService.getCurrentLocationForecast(lat, lon, appId, units, count)
    }

    override fun getCityForecast(
        cityName: String,
        appId: String,
        units: String,
        count: String
    ): Observable<Forecast> {
        return apiService.getCityForecast(cityName, appId, units, count)
    }

}