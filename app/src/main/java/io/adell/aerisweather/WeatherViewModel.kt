package io.adell.aerisweather

import android.arch.lifecycle.ViewModel
import io.adell.aerisweather.RequestExecutor.CIENT_SECRET
import io.adell.aerisweather.RequestExecutor.CLIENT_ID
import io.adell.aerisweather.data.Period
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherViewModel : ViewModel() {
    private var forecastEvent = SingleLiveEvent<List<Period>>()
    private var viewInstructions = SingleLiveEvent<ViewInstruction>()


    init {
        getWeather()
    }

    private fun getWeather() {
        RequestExecutor.aerisApi.getForecasts(CLIENT_ID, CIENT_SECRET)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            val success = it?.success ?: false
                            if (success) {
                                it?.response?.get(0)?.periods?.let { forecastEvent.postValue(it) }
                            } else {
                                viewInstructions.postValue(ViewInstruction.NetworkError())
                            }
                        },
                        {
                            viewInstructions.postValue(ViewInstruction.NetworkError())
                        }
                )
    }

    sealed class ViewInstruction {
        class NetworkError : ViewInstruction()
    }
}