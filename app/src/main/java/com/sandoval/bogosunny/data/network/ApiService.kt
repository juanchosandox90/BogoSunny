package com.sandoval.bogosunny.data.network

import io.reactivex.Observable
import com.sandoval.bogosunny.data.network.model.forecast.Forecast
import com.sandoval.bogosunny.data.network.model.weather.CurrentWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    abstract fun getCurrentLocationWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("APPID") appId: String,
        @Query("units") units: String
    ): Observable<CurrentWeather>

    @GET("weather")
    abstract fun getCityWeather(
        @Query("q") cityName: String,
        @Query("APPID") appId: String,
        @Query("units") units: String
    ): Observable<CurrentWeather>

    @GET("forecast")
    abstract fun getCurrentLocationForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("APPID") appId: String,
        @Query("units") units: String,
        @Query("cnt") count: String
    ): Observable<Forecast>

    @GET("forecast")
    abstract fun getCityForecast(
        @Query("q") cityName: String,
        @Query("APPID") appId: String,
        @Query("units") units: String,
        @Query("cnt") count: String
    ): Observable<Forecast>
}