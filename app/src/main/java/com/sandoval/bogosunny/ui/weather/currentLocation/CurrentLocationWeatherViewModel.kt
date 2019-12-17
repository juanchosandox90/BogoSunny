package com.sandoval.bogosunny.ui.weather.currentLocation

import androidx.lifecycle.ViewModel
import com.sandoval.bogosunny.data.Config
import com.sandoval.bogosunny.data.DataManager
import com.sandoval.bogosunny.data.network.model.forecast.Forecast
import com.sandoval.bogosunny.data.network.model.weather.CurrentWeather
import io.reactivex.Observable
import javax.inject.Inject

class CurrentLocationWeatherViewModel @Inject
constructor(
    private val dataManager: DataManager
) : ViewModel() {
    fun getWeatherData(lat: String, lng: String): Observable<CurrentWeather> {
        return dataManager.getCurrentLocationWeather(
            lat,
            lng,
            Config.API_KEY,
            "metric"
        )
    }

    fun getForecastData(lat: String, lng: String): Observable<Forecast> {
        return dataManager.getCurrentLocationForecast(
            lat,
            lng,
            Config.API_KEY,
            "metric",
            "5"
        )
    }
}