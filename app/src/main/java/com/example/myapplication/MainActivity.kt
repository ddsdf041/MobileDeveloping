package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background){
                    AppNavigation()
                }
            }
        }
    }
}
@Composable
internal fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens. MainScreen.screenName) {
        composable(Screens. MainScreen.screenName) { MainScreen(navController = navController) }
//        composable(Screens. ChatScreen.screenName) { ChatScreen(navController = navController) }
        composable(
            route = Screens.ChatScreen.screenName + "/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })) {
            stackEntry ->
            val index = stackEntry.arguments?.getInt("index")
            ChatScreen(navController = navController, index)}
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        Greeting("Android")
//    }
//}