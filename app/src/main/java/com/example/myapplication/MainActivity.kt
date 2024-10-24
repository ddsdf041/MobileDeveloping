package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.myapplication.data.WeatherApi
import com.example.myapplication.data.WeatherModel
import com.example.myapplication.scenes.DialogSearch
import com.example.myapplication.scenes.MainCard
import com.example.myapplication.scenes.TabLayout
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

const val API_KEY = "1bc852f12aed46a9a1d165600240610"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val daysList = remember {
                    mutableStateOf(listOf<WeatherModel>())
                }
                val dialogState = remember {
                    mutableStateOf(false)
                }
                val currentDay = remember {
                    mutableStateOf(
                        WeatherModel(
                            "",
                            "",
                            "0.0",
                            "",
                            "",
                            "0.0",
                            "0.0",
                            listOf()
                        )
                    )
                }

                if (dialogState.value) DialogSearch(dialogState, onSubmit = {
                    getData(
                        city = it,
                        context = this@MainActivity,
                        daysList = daysList,
                        currentDay = currentDay
                    )
                })

                getData(
                    city = "Коломна",
                    context = this,
                    daysList = daysList,
                    currentDay = currentDay
                )

                Image(
                    painter = painterResource(
                        id = R.drawable.weather_bg
                    ),
                    contentDescription = "im1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.5f),
                    contentScale = ContentScale.FillBounds
                )
                Column {
                    MainCard(currentDay,
                        onClickSync = {
                            getData(
                                city = "Коломна",
                                context = this@MainActivity,
                                daysList = daysList,
                                currentDay = currentDay
                            )
                        },
                        onClickSearch = {
                            dialogState.value = true
                        })
                    TabLayout(daysList, currentDay)
                }
            }
        }
    }
}

private fun getData(
    city: String, context: Context,
    daysList: MutableState<List<WeatherModel>>,
    currentDay: MutableState<WeatherModel>
) {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: WeatherApi = retrofit.create(WeatherApi::class.java)

    val job = CoroutineScope(Dispatchers.IO).launch() {
        val weather = service.getWeather(city)

        daysList.value = weather.forecast.forecastday.map { forecastDay ->
            WeatherModel(
                city = weather.location.name,
                time = forecastDay.date,
                currentTemp = "",
                condition = forecastDay.day.condition.text,
                icon = forecastDay.day.condition.icon,
                maxTemp = forecastDay.day.maxTemp.toFloat().toInt().toString() + "°C",
                minTemp = forecastDay.day.minTemp.toFloat().toInt().toString() + "°C",
                hours = forecastDay.hour
            )
        }

        currentDay.value = daysList.value.first().copy(
            time = weather.current.time,
            currentTemp = weather.current.currentTemp.toFloat().toInt().toString() + "°C",
        )
    }

    job //Можно проверить на ошибку
}