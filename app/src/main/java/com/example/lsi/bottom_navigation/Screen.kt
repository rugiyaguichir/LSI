package com.example.lsi.bottom_navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Screen1() {
    
    Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "About us",
        textAlign = TextAlign.Center)
    
}

@Composable
fun Screen2() {

    Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Services",
        textAlign = TextAlign.Center)

}

@Composable
fun Screen3() {

    Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Contacts",
        textAlign = TextAlign.Center)

}