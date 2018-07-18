package io.adell.aerisweather

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView

class WeatherFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_weather, container, false)

    private lateinit var viewModel: WeatherViewModel
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherAdapter = WeatherAdapter(context)
        viewModel = ViewModelProviders.of(activity).get(WeatherViewModel::class.java)
        viewModel.forecastEvent.observe(this, Observer { weatherAdapter.setDays(it) })
        viewModel.forecastEvent.value?.let { weatherAdapter.setDays(it) }
        view?.apply {
            findViewById<GridView>(R.id.fragment_weather_grid_view).apply { adapter = weatherAdapter }
        }
    }

    companion object {
        const val TAG = "WeatherFragment"
        fun newInstance() = WeatherFragment()
    }
}

