package com.example.appmeseritos.ui.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    //Home
    var userHome: MutableState<String> = mutableStateOf("")
    fun setuserHome(newUserHome: String) {
        userHome.value = newUserHome
    }
    var passHome: MutableState<String> = mutableStateOf("")
    fun setPassHome(newpassHome: String) {
        passHome.value = newpassHome
    }

    //Menu
    var searchMenu: MutableState<String> = mutableStateOf("")
    fun setSearchMenu(search: String){
        searchMenu.value = search
    }
    var tableMenu: MutableState<String> = mutableStateOf("1")
    fun settableMenu(table: String){
        tableMenu.value = table
    }

    //PerssonelAdjustment
    var PerssonelAdjustment: MutableState<String> = mutableStateOf("")
    fun setPerssonelAdjustment(Personnel: String){
        PerssonelAdjustment.value = Personnel
    }

    //MenuSetting
    var MenuSetting: MutableState<String> = mutableStateOf("")
    fun setMenuSetting(Menu: String){
        MenuSetting.value = Menu
    }

    //AddNewFood
    var NameNewFood: MutableState<String> = mutableStateOf("")
    fun setNameNewFood(name: String){
        NameNewFood.value = name
    }
    var CountNewFood: MutableState<String> = mutableStateOf("")
    fun setCountNewFood(count: String){
        CountNewFood.value = count
    }
    var DescriptionNewFood: MutableState<String> = mutableStateOf("")
    fun setDescriptionNewFood(description: String){
        DescriptionNewFood.value = description
    }

    //ListToOrder
    var howManyListToOrder: MutableState<String> = mutableStateOf("")
    fun sethowManyListToOrder(HowMany: String){
        howManyListToOrder.value = HowMany
    }
    var extraDetailsListToOrder: MutableState<String> = mutableStateOf("")
    fun setextraDetailsListToOrder(extraDetails: String){
        extraDetailsListToOrder.value = extraDetails
    }

    //AddPersonnel
    var nameNewPerssonel: MutableState<String> = mutableStateOf("")
    fun setnameNewPerssonel(NewNamePerssonel: String) {
        nameNewPerssonel.value = NewNamePerssonel
    }
    var lastNameNewPerssonel: MutableState<String> = mutableStateOf("")
    fun setlastNameNewPerssonel(NewLastnamePerssonel: String) {
        lastNameNewPerssonel.value = NewLastnamePerssonel
    }
    var rfcNewPerssonel: MutableState<String> = mutableStateOf("")
    fun setrfcNewPerssonel(NewrfcPerssonel: String) {
        rfcNewPerssonel.value = NewrfcPerssonel
    }
    var phoneNewPerssonel: MutableState<String> = mutableStateOf("")
    fun setPhoneNewPerssonel(NewphonePerssonel: String) {
        phoneNewPerssonel.value = NewphonePerssonel
    }
    var jobNewPerssonel: MutableState<String> = mutableStateOf("Chef")
    fun setjobNewPerssonel(NewLastnamePerssonel: String) {
        jobNewPerssonel.value = NewLastnamePerssonel
    }
    var userNewPerssonel: MutableState<String> = mutableStateOf("")
    fun setUserNewPerssonel(NewUserPerssonel: String) {
        userNewPerssonel.value = NewUserPerssonel
    }
    var passNewPerssonel: MutableState<String> = mutableStateOf("")
    fun setPassNewPerssonel(NewPassPerssonel: String) {
        passNewPerssonel.value = NewPassPerssonel
    }



}