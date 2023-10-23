package com.example.appmeseritos.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmeseritos.screens.AdministrationScreen
import com.example.appmeseritos.screens.BillScreen
import com.example.appmeseritos.screens.DetailsFood
import com.example.appmeseritos.screens.HomeScreen
import com.example.appmeseritos.screens.ListToOrders
import com.example.appmeseritos.screens.Menu
import com.example.appmeseritos.screens.MenuSettingScreen
import com.example.appmeseritos.screens.NewFood
import com.example.appmeseritos.screens.PersonnelAdjustmentsScreen


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppVavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreens.HomeScreen.route
    ){
        composable(route = AppScreens.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = AppScreens.ListToOrdersScreen.route){
            ListToOrders(navController)
        }
        composable(route = AppScreens.Menu.route){
            Menu(navController)
        }
        composable(route = AppScreens.DetailsFood.route){
            DetailsFood(navController)
        }
        composable(route = AppScreens.BillScreen.route){
            BillScreen(navController)
        }
        composable(route = AppScreens.AdminScreen.route){
            AdministrationScreen(navController)
        }
        composable(route = AppScreens.MenuSetting.route){
            MenuSettingScreen(navController)
        }
        composable(route = AppScreens.PersonnelAdjustments.route){
            PersonnelAdjustmentsScreen(navController)
        }
        composable(route = AppScreens.NewFood.route){
            NewFood(navController)
        }
    }
}