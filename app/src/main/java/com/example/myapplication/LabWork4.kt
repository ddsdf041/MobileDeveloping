package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SecondScreen(){
    Scaffold (
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(
                title= { Text("My First App")},
                navigationIcon={
                    IconButton({})
                    {
                        Icon(Icons.Filled.FavoriteBorder,
                            contentDescription = "Menu",
                            modifier = Modifier.size(50.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar{
                IconButton({}, modifier = Modifier.size(40.dp))
                {
                    Icon(Icons.Filled.DateRange, contentDescription = "DateRange Icon",
                    modifier = Modifier.size(30.dp))
                }

                Spacer(Modifier.weight(1f, true))

                IconButton({},modifier = Modifier
                     .size(50.dp)
                     .padding(10.dp))
                {
                    Icon(Icons.Filled.Home,contentDescription = "Home Icon",
                    modifier = Modifier.size(50.dp))
                }

                Spacer(Modifier.weight(1f, true))

                IconButton({}, modifier = Modifier.size(40.dp))
                {
                    Icon(Icons.Filled.AccountCircle, contentDescription = "AccountCircle Icon",
                    modifier = Modifier.size(30.dp))
                }
            }
        }
    ) {
        padding -> padding
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Text(
                    "Hello! That`s your last chats",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(20.dp, top = 80.dp, bottom = 20.dp)
                )
            }
            items(100) { index ->
                Row(
                    modifier = Modifier.padding(5.dp, bottom = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(
                            start = 5.dp, end = 5.dp,
                            top = 5.dp, bottom = 10.dp
                        )

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = "Image",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color.Gray)
                        )
                        Column(
                            modifier = Modifier.padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Chat number $index",
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace
                            )
                            Text(
                                modifier = Modifier.padding(top = 5.dp),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 2,
                                text = "That a simple example for chat number $index. " +
                                        "I just want to see this text on two lines " +
                                        "so that you can try to make a restriction"
                            )
                        }
                    }
                }
                HorizontalDivider(color = Color.LightGray)
            }
        }
    }
}



@Preview
@Composable
private fun preview(){
    SecondScreen()
}