package io.adell.aerisweather.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Period(
        @SerializedName("timestamp")
        @Expose
        var timestamp: Int,
        @SerializedName("validTime")
        @Expose
        var validTime: String,
        @SerializedName("dateTimeISO")
        @Expose
        var dateTimeISO: String,
        @SerializedName("maxTempC")
        @Expose
        var maxTempC: Int,
        @SerializedName("maxTempF")
        @Expose
        var maxTempF: Int,
        @SerializedName("minTempC")
        @Expose
        var minTempC: Int,
        @SerializedName("minTempF")
        @Expose
        var minTempF: Int,
        @SerializedName("avgTempC")
        @Expose
        var avgTempC: Int,
        @SerializedName("avgTempF")
        @Expose
        var avgTempF: Int,
        @SerializedName("icon")
        @Expose
        var icon: String)

