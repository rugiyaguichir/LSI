package com.example.lsi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lsi.R
import com.example.lsi.data.DoctorsModel

@Composable
fun doctorInformation(doctorId: Long, doctorsList: MutableState<List<DoctorsModel>>) {
    val selectedDoctor = doctorsList.value.find { it.id == doctorId }
    if (selectedDoctor != null) {
        Column (modifier = Modifier.fillMaxSize()){
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
                    text = "About doctors",
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
                        Box(modifier = Modifier) {
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            )
                            {
                                Box(modifier = Modifier.fillMaxWidth()) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(15.dp),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column(modifier = Modifier
                                            .fillMaxWidth()) {
                                            Row(modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.photo_1),
                                                    contentDescription = "doctor image",
                                                    contentScale = Crop,
                                                    modifier = Modifier
                                                        .padding(6.dp)
                                                        .size(128.dp)
                                                        .clip(CircleShape)
                                                )
                                                Column(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalAlignment = Alignment.CenterHorizontally,
                                                    verticalArrangement = Arrangement.Center
                                                ) {
                                                    Text(
                                                        text = selectedDoctor.name,
                                                        fontSize = 24.sp,
                                                        fontWeight = FontWeight.Bold
                                                    )

                                                    Text(
                                                        text = selectedDoctor.specialization,
                                                        fontSize = 18.sp,
                                                        color = Color.Gray
                                                    )
                                                }
                                            }


                                            LazyColumn(
                                                modifier = Modifier.fillMaxWidth(),
                                            ) {
                                                item {
                                                    Text(
                                                        text = selectedDoctor.longDescription,
                                                        fontSize = 18.sp,
                                                        modifier = Modifier.padding(16.dp),
                                                        softWrap = true,
                                                        maxLines = Int.MAX_VALUE
                                                    )
                                                }
                                            }
                                        }

                                    }

                                    // Другие элементы подробной информации
                                }
                            }
                        }
                    }

                }
            }
        }
    }else {

    }
}
// Здесь вы можете отобразить подробную информацию о `selectedItem`
