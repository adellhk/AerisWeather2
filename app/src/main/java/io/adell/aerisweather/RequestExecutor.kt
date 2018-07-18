package io.adell.aerisweather

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestExecutor {
    const val AERIS_URL = "http://api.aerisapi.com"
    const val CLIENT_ID = "uDCAAQXSTixXoZr627IwQ"
    const val CIENT_SECRET = "k1fmwIkpur45qkDRyjyfpTcwwkuQzKjIAZT6W8Sl"

    val aerisApi: AerisApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(AERIS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        aerisApi = retrofit.create(AerisApi::class.java)
    }

}

