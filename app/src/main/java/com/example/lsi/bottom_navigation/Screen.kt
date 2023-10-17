package com.example.lsi.bottom_navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.lsi.ItemRowModel
import com.example.lsi.MyRow
import com.example.lsi.R
import com.example.lsi.data.DoctorsModel
import com.example.lsi.ui.theme.Gray100
import com.example.lsi.ui.theme.Purple80

@Composable
fun Screen1() {

    Column {
        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .size(50.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "About LSI",
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(645.dp),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 5.dp
                ) {
                    Box(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Column {
                                Text(text = "The headquarter of LSI is located in Los Angeles, California, United States; responsible for coordination, administration, development, and training. The operations of LSI is managed by its Advisory Committee, Board of Directors, Ministry Director, Executive Committee, and co-workers.")

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "Our Service Locations",
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(end = 8.dp),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Box(modifier = Modifier.padding(16.dp)) {
                                        Image(
                                            painter = painterResource(id = R.drawable.map2),
                                            contentDescription = "Map",
                                            modifier = Modifier
                                                .size(220.dp)
                                                .clip(shape = RoundedCornerShape(15.dp))
                                                .clickable { /* Handle image click */ }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun Screen2(doctorsList: MutableState<List<DoctorsModel>>, navController: NavController, list: List<DoctorsModel>) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .size(50.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Our services",
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 5.dp
                ) {
                    Box(modifier = Modifier.padding(5.dp)) {
                        LazyColumn(modifier = Modifier
                            .fillMaxWidth()
                            .background(Gray100),
                        ) {
                            itemsIndexed(
                                doctorsList.value
                            ){_, item ->
                               MyRow(item = item, navController, list)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Screen3() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .size(50.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Contact Us",
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(15.dp),
                    elevation = 5.dp
                ) {
                    Box(modifier = Modifier.padding(16.dp)) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                elevation = 0.dp
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Luke Service International",
                                        modifier = Modifier.padding(
                                            bottom = 10.dp,
                                        ),
                                        style = TextStyle(fontSize = 20.sp),
                                        color = Color.Black
                                    )
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceEvenly
                                    ) {
                                        Column(
                                        ) {
                                            Text(
                                                text = "Address:",
                                                style = TextStyle(fontSize = 10.sp),
                                                color = Color.Black
                                            )
                                            Text(
                                                text = "Tokmok",
                                                modifier = Modifier.padding(bottom = 10.dp),
                                                style = TextStyle(fontSize = 15.sp),
                                                color = Color.Black
                                            )
                                            Text(
                                                text = "Home Address:",
                                                style = TextStyle(fontSize = 10.sp),
                                                color = Color.Black
                                            )
                                            Text(
                                                text = "Shamsinskaya 141a",
                                                modifier = Modifier.padding(bottom = 10.dp),
                                                style = TextStyle(fontSize = 15.sp),
                                                color = Color.Black
                                            )
                                        }
                                        Column() {
                                            Text(
                                                text = "+996555555555",
                                                style = TextStyle(fontSize = 15.sp),
                                                color = Color.Black
                                            )
                                            Text(
                                                text = "+996302222222",
                                                style = TextStyle(fontSize = 15.sp),
                                                color = Color.Black
                                            )
                                            Text(
                                                text = "wwww.google.com",
                                                style = TextStyle(fontSize = 15.sp),
                                                color = Color.Black
                                            )
                                        }
                                        Image(
                                            painter = painterResource(id = R.drawable.logos),
                                            contentDescription = "logo",
                                            modifier = Modifier.size(70.dp)
                                        )
                                    }
                                }
                            }
                            Text(
                                text = "Google map",
                                modifier = Modifier.padding(15.dp),
                                style = TextStyle(fontSize = 20.sp),
                                color = Color.Black
                            )
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                elevation = 0.dp,
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.google_map),
                                    contentDescription = "map",
                                    modifier = Modifier.size(250.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun Screen4() {
}