package com.example.lsi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lsi.data.DoctorsModel

@Composable
fun MyRow(item: DoctorsModel, navController: NavController, list: List<DoctorsModel>) {
    Row(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .background(Color.White)
            .clickable {
                navController.navigate(
                    "doctorInformation/${item.id}"
                )
            },
    ) {
        Image(painter = painterResource(id = R.drawable.photo_1),
            contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(3.dp)
            .size(64.dp)
            .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp)
        ) {
            Text(text = item.name)
            Text(text = item.shortDescription)
        }


    }
}