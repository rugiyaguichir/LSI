package com.example.lsi.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lsi.data.DoctorsModel
import com.example.lsi.screens.doctorInformation

@Composable
fun NavGraph(
    navHostController: NavHostController, doctorsList: MutableState<List<DoctorsModel>>,list: List<DoctorsModel>
) {
    NavHost(navController = navHostController, startDestination = "screen_1"){
        composable("screen_1"){
            Screen1()
        }
        composable("screen_2"){
            Screen2(doctorsList, navController = navHostController, list)
        }
        composable("screen_3"){
            Screen3()
        }
        composable("doctorInformation/{itemId}", arguments = listOf(navArgument("itemId") { type = NavType.LongType })){
                backStackEntry ->
            val itemId = backStackEntry.arguments?.getLong("itemId")
            if (itemId != null) {
                doctorInformation(itemId, doctorsList)
            } else {

            }
        }
    }
}