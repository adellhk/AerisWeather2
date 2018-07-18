package io.adell.aerisweather.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ForecastResponseWrapper(
        @SerializedName("success")
        @Expose var success: Boolean,
        @SerializedName("error")
        @Expose
        private var error: Any,
        @SerializedName("response")
        @Expose var response: List<Response>)