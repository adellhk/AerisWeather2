package io.adell.aerisweather

import io.adell.aerisweather.data.ForecastResponseWrapper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface AerisApi {
    @GET("/forecasts/11101")
    fun getForecasts(@Query("client_id") clientId: String, @Query("client_secret") clientSecret: String): Observable<ForecastResponseWrapper>

}