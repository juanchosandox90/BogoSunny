package com.sandoval.bogosunny.data.network

import com.sandoval.bogosunny.data.network.model.forecast.Forecast
import com.sandoval.bogosunny.data.network.model.weather.CurrentWeather
import io.reactivex.Observable

interface ApiHelper {
    abstract fun getCurrentLocationWeather(
        lat: String,
        lon: String,
        appId: String,
        units: String
    ): Observable<CurrentWeather>

    abstract fun getCityWeather(
        cityName: String,
        appId: String,
        units: String
    ): Observable<CurrentWeather>

    abstract fun getCurrentLocationForecast(
        lat: String,
        lon: String,
        appId: String,
        units: String,
        count: String
    ): Observable<Forecast>

    abstract fun getCityForecast(
        cityName: String,
        appId: String,
        units: String,
        count: String
    ): Observable<Forecast>

}
