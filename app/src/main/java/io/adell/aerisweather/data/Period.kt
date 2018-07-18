package io.adell.aerisweather.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Period(
        @SerializedName("timestamp")
        @Expose
        private var timestamp: Int,
        @SerializedName("validTime")
        @Expose
        private var validTime: String,
        @SerializedName("dateTimeISO")
        @Expose
        private var dateTimeISO: String,
        @SerializedName("maxTempC")
        @Expose
        private var maxTempC: Int,
        @SerializedName("maxTempF")
        @Expose
        private var maxTempF: Int,
        @SerializedName("minTempC")
        @Expose
        private var minTempC: Int,
        @SerializedName("minTempF")
        @Expose
        private var minTempF: Int,
        @SerializedName("avgTempC")
        @Expose
        private var avgTempC: Int,
        @SerializedName("avgTempF")
        @Expose
        private var avgTempF: Int)
