package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.scenes.MainCard
import com.example.myapplication.scenes.TabLayout
import com.example.myapplication.ui.theme.MyApplicationTheme

const val API_KEY = "6c2a92c79a8c4513906174753240410"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                getData("London", this)
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
                    MainCard()
                    TabLayout()
                }
            }
        }
    }
}


private fun getData(city: String, context: Context){
    val url = "https://api.weatherapi.com/v1/current.json" +
            "?key=$API_KEY" +
            "&q=$city" +
            "&days=3" +
            "&aqi=no" +
            "&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        {
                response ->
            Log.d("MyLog", "Response $response")
        },
        {
                error ->
            Log.d("MyLog", "VolleyError $error")
        }
    )
    queue.add(stringRequest)
}