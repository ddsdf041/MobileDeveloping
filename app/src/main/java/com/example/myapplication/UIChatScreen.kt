package com.example.myapplication

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(navController: NavController, index: Int?){
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold (
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                content = {Icon(Icons.Filled.FavoriteBorder, contentDescription = "Click me")},
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Hello :^)")
                    }
                }
            )
        },
        topBar = {
            TopAppBar(
                title= {Text("Chat number $index", modifier = Modifier.padding(start = 50.dp)) },
                navigationIcon={
                    IconButton(onClick = {navController.popBackStack()})
                    {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go Back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar{
                Row {
                    Text(
                        text = "С прошедшем Анна Петровна!!!",
                        fontSize = 25.sp,
                        modifier = Modifier.padding(start = 20.dp, top = 5.dp, end = 20.dp))
                    Spacer(Modifier.weight(1f, true))
                    Button({}) {
                        Icon(
                            Icons.AutoMirrored.Filled.Send,
                            contentDescription = "Send"
                        )
                    }
                }
            }
        }
    ) { paddingValues -> paddingValues
    }
}

//@Preview
//@Composable
//private fun preview(){
//    val navController = rememberNavController()
//    ChatScreen(navController = navController, 0)
//}