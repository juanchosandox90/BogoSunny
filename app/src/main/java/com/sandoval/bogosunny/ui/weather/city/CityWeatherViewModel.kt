package com.sandoval.bogosunny.ui.weather.city

import androidx.lifecycle.ViewModel
import com.sandoval.bogosunny.data.Config
import com.sandoval.bogosunny.data.DataManager
import com.sandoval.bogosunny.data.network.model.forecast.Forecast
import com.sandoval.bogosunny.data.network.model.weather.CurrentWeather
import io.reactivex.Observable
import javax.inject.Inject

class CityWeatherViewModel
@Inject constructor(
    private val dataManager: DataManager
) : ViewModel() {

    fun getWeatherData(city: String): Observable<CurrentWeather> {
        return dataManager.getCityWeather(
            city,
            Config.API_KEY,
            "metric"
        )
    }

    fun getForecastData(city: String): Observable<Forecast> {
        return dataManager.getCityForecast(
            city,
            Config.API_KEY,
            "metric",
            "5"
        )
    }
}