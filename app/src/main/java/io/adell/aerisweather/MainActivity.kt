package io.adell.aerisweather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWeatherFragment()
    }

    private fun setupWeatherFragment() {
        supportFragmentManager.findFragmentByTag(WeatherFragment.TAG) ?:
                WeatherFragment.newInstance()
                        .apply {
                            supportFragmentManager.beginTransaction()
                                    .replace(R.id.content_frame, this)
                                    .commit()
                        }
    }
}

