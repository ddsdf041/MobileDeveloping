package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myapplication.scenes.MainScreen
import com.example.myapplication.ui.theme.MyApplicationTheme


//const val API_KEY = "6c2a92c79a8c4513906174753240410"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainScreen()
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> innerPadding
//                    Greeting("London", this)
//                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, context: Context) {
//    val state = remember {
//        mutableStateOf("Unknown")
//    }
//    Column(modifier = Modifier.fillMaxSize()) {
//        Box(
//            modifier = Modifier.fillMaxHeight(0.5f)
//            .fillMaxWidth(),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(text = "Temp in $name = ${state.value}"
//            )
//        }
//        Box(
//            modifier = Modifier.fillMaxHeight()
//            .fillMaxWidth(),
//            contentAlignment = Alignment.BottomCenter
//        ) {
//            Button(onClick = {
//                getResult(name, state, context)
//            },
//                modifier = Modifier.padding(5.dp)
//                    .fillMaxWidth()
//            ) {
//                Text(text = "Refresh")
//            }
//        }
//    }
//}


//private fun getResult(city:String, state: MutableState<String>, context:Context){
//    val url = "https://api.weatherapi.com/v1/current.json" +
//            "?key=$API_KEY&" +
//            "q=$city" +
//            "&aqi=no"
//    val queue = Volley.newRequestQueue(context)
//    val stringRequest = StringRequest(
//        Request.Method.GET,
//        url,
//        {
//            response ->
//            state.value = response
//            val obj = JSONObject(response)
//            state.value = obj.getJSONObject("current").getString("temp_c")
//        },
//        {
//            error ->
//            Log.d("MyLog", "Error $error")
//        }
//    )
//    queue.add(stringRequest)
//}