package com.example.appmeseritos.navigation

sealed class AppScreens(val route: String){
    object HomeScreen: AppScreens("home_screen")
    object ListToOrdersScreen: AppScreens("list_to_orders_screen")
    object Menu: AppScreens("menu_screen")
    object DetailsFood: AppScreens("details_food")
    object BillScreen: AppScreens("bill_screen")
    object AdminScreen: AppScreens("administration_screen")
    object MenuSetting: AppScreens("menusetting_screen")
    object PersonnelAdjustments: AppScreens("personneladjustments_screen")
    object NewFood: AppScreens("newfood_screen")
    object AddPersonnel: AppScreens("addpersonnel_screen")
}
