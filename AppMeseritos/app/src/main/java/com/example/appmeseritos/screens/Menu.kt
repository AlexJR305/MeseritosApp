package com.example.appmeseritos.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FactCheck
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmeseritos.navigation.AppScreens

import com.example.appmeseritos.R
import com.example.appmeseritos.ui.theme.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesingMenu(navController: NavController){
    //Variables
    val miViewModel = viewModel<MainViewModel>()

    Scaffold (
        topBar = {
            TopAppBar(
                title = { 
                    Column {
                        BoxWithConstraints {
                            //Adaptacion del tamano de pantallas
                            val WidthScreenTittle: Int
                            val WidthScreenBack: Int
                            if (maxWidth < 400.dp) {
                                WidthScreenTittle = 25
                                WidthScreenBack = 45
                            } else {
                                WidthScreenTittle = 38
                                WidthScreenBack = 140
                            }
                            Row {
                                IconButton(onClick = { navController.navigate(AppScreens.HomeScreen.route) }) {
                                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null,
                                        modifier = Modifier.size(WidthScreenBack.dp))
                                }
                                Text(text = "Mesa #${miViewModel.tableMenu.value}",
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(top = 8.dp),
                                    fontSize = WidthScreenTittle.sp
                                )
                            }
                        }

                    }
                })
        },
        bottomBar = {
            BottomAppBar (
                containerColor = MaterialTheme.colorScheme.primary
            )
            {
                BoxWithConstraints {
                    var WidthScreen : Int
                    var WidthScreenTextButton : Int
                    var WidthScreenIcon : Int
                    if(maxWidth < 400.dp){
                        WidthScreen = 118
                        WidthScreenTextButton = 17
                        WidthScreenIcon = 27
                    }else{
                        WidthScreen = 260
                        WidthScreenTextButton = 27
                        WidthScreenIcon = 34
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    ){
                        //Boton para pedir cuenta
                        TextButton(
                            onClick = { navController.navigate(AppScreens.BillScreen.route)},
                            modifier = Modifier
                                .padding(5.dp)
                                .height(48.dp)
                                .width(WidthScreen.dp)
                                .background(Color.Black)
                        ) {
                            Row(
                            ) {
                                Icon(imageVector = Icons.Filled.FactCheck, contentDescription = null,
                                    modifier = Modifier.size(WidthScreenIcon.dp))
                                Text(
                                    text = stringResource(id = R.string.Checked),
                                    style = MaterialTheme.typography.titleLarge,
                                    color = Color.White, // Color del texto
                                    fontSize = WidthScreenTextButton.sp,
                                )
                            }
                        }

                        //Boton para ordenar
                        TextButton(
                            onClick = { navController.navigate(AppScreens.Menu.route) },
                            modifier = Modifier
                                .padding(5.dp)
                                .height(48.dp)
                                .width(WidthScreen.dp)
                                .background(Color.Black)
                        ) {
                            Row(
                            ) {
                                Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = null,
                                    modifier = Modifier.size(WidthScreenIcon.dp))
                                Text(
                                    text = stringResource(id = R.string.Order),
                                    style = MaterialTheme.typography.titleLarge,
                                    color = Color.White, // Color del texto
                                    fontSize = WidthScreenTextButton.sp,
                                )
                            }
                        }
                        //Boton para el personal
                        TextButton(
                            onClick = { navController.navigate(AppScreens.HomeScreen.route) },
                            modifier = Modifier
                                .padding(5.dp)
                                .height(48.dp)
                                .width(WidthScreen.dp)
                                .background(Color.Black)
                        ) {
                            Row(
                            ) {
                                Icon(imageVector = Icons.Filled.SupervisorAccount, contentDescription = null,
                                    modifier = Modifier.size(WidthScreenIcon.dp))
                                Text(
                                    text = stringResource(id = R.string.Personal),
                                    style = MaterialTheme.typography.titleLarge,
                                    color = Color.White, // Color del texto
                                    fontSize = WidthScreenTextButton.sp,
                                )
                            }
                        }
                    }
                }
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ){
        BoxWithConstraints {
            var WidthScreenTextField: Int
            var WidthScreenText: Int
            var WidthScreenPict : Int
            if (maxWidth < 400.dp) {
                WidthScreenText = 30
                WidthScreenTextField = 260
                WidthScreenPict = 150
            } else {
                WidthScreenText = 60
                WidthScreenTextField = 430
                WidthScreenPict = 300
            }

            LazyColumn (modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp, bottom = 50.dp)
            ){
                item{
                    Row {
                        Text(text = stringResource(id = R.string.Menu),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge.copy(fontSize = 40.sp),
                            fontSize = WidthScreenText.sp
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        OutlinedTextField(
                            value = miViewModel.searchMenu.value,
                            onValueChange = {Search ->
                                miViewModel.setSearchMenu(Search)
                            },
                            label = { Text(text = stringResource(id = R.string.Search)) },
                            placeholder = { Text(text = stringResource(id = R.string.Search)) },
                            leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar") },
                            modifier = Modifier
                                .width(WidthScreenTextField.dp)
                                .height(58.dp)
                        )
                    }
                }
                items(6) { index ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    ) {
                        IconButton(
                            onClick = { navController.navigate(route = AppScreens.DetailsFood.route) },
                            modifier = Modifier.size(WidthScreenPict.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.captura),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Spacer(modifier = Modifier.width(30.dp))
                        IconButton(
                            onClick = { navController.navigate(route = AppScreens.DetailsFood.route) },
                            modifier = Modifier.size(WidthScreenPict.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.captura),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }


    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(navController: NavController){
    Scaffold {
        DesingMenu(navController)
    }
}