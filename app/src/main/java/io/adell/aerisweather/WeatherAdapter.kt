package io.adell.aerisweather

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import io.adell.aerisweather.data.Period
import java.text.ParseException
import java.text.SimpleDateFormat


class WeatherAdapter(private val context: Context) : BaseAdapter() {

    private var days: List<Period>? = null

    fun setDays(days: List<Period>?) {
        this.days = days
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return if (days == null) {
            0
        } else {
            days!!.size
        }
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        if (view == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.grid_item_weather_period_day, viewGroup, false)
        }
        val day = days?.get(i)
        view?.apply {
            try {
                val originalFormat = SimpleDateFormat("yyyy-mm-dd")
                val dateTimeISO = originalFormat.parse(day?.dateTimeISO)
                val formattedDate = SimpleDateFormat("EEEE").format(dateTimeISO)
                findViewById<AppCompatTextView>(R.id.weather_day_grid_item_date).text = formattedDate
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            day?.maxTempF?.let { findViewById<AppCompatTextView>(R.id.grid_item_weather_period_day_high).text = it.toString() + "F" }
            day?.minTempF?.let { findViewById<AppCompatTextView>(R.id.grid_item_weather_period_day_low).text = it.toString() + "F" }
            day?.icon?.let {
                val iconName = it.substring(0, it.lastIndexOf('.'))
                val drawableId = weatherIconHelper(iconName)
                if (drawableId != 0) {
                    findViewById<AppCompatImageView>(R.id.weather_day_grid_item_icon).setImageResource(drawableId)
                }
            }
        }

        return view!!
    }

    private fun weatherIconHelper(iconName: String): Int {
        return context.resources.getIdentifier(iconName, "drawable", context.packageName)
    }
}