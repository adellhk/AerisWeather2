package io.adell.aerisweather

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import rx.Single

class WeatherViewModel : ViewModel() {
    private var forecastEvent = SingleLiveEvent<Forecast>()
    init {
        getWeather()
    }

    private fun getWeather() {

    }
}