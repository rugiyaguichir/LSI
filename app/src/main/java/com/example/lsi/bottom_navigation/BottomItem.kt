package com.example.lsi.bottom_navigation

import com.example.lsi.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String){
    object Screen1: BottomItem("About us", R.drawable.home, "screen_1")
    object Screen2: BottomItem("Services", R.drawable.services, "screen_2")
    object Screen3: BottomItem("Contacts", R.drawable.contacts, "screen_3")

    
}
