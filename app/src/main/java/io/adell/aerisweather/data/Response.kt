package io.adell.aerisweather.data

import com.google.gson.annotations.Expose

class Response(
        @Expose var periods: List<Period>)