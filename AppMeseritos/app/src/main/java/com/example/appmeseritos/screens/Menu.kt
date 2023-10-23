package com.example.appmeseritos.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmeseritos.navigation.AppScreens

import com.example.appmeseritos.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesingMenu(navController: NavController){
    //Variables
    var Mesa by remember{ mutableStateOf("") }
    var Search by remember{ mutableStateOf("") }
    Scaffold (
        topBar = {
            TopAppBar(
                title = { 
                    Column {
                        Row {
                            IconButton(onClick = { navController.navigate(AppScreens.HomeScreen.route) }) {
                                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                            }
                            Text(text = "Mesa #$Mesa",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }

                    }
                })
        },
        bottomBar = {
            BottomAppBar (
                containerColor = MaterialTheme.colorScheme.primary
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                ){
                    //Boton para pedir cuenta
                    TextButton(
                        onClick = { navController.navigate(route = AppScreens.BillScreen.route) },
                        modifier = Modifier
                            .padding(5.dp)
                            .height(48.dp)
                            .background(Color.Black)
                    ) {
                        Row(
                        ) {
                            Icon(imageVector = Icons.Filled.FactCheck, contentDescription = null)
                            Text(
                                text = stringResource(id = R.string.Checked),
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White, // Color del texto
                                fontSize = 18.sp,
                            )
                        }
                    }

                    //Boton para ordenar
                    TextButton(
                        onClick = { navController.navigate(AppScreens.Menu.route) },
                        modifier = Modifier
                            .padding(5.dp)
                            .height(48.dp)
                            .background(Color.Black)
                    ) {
                        Row(
                        ) {
                            Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = null)
                            Text(
                                text = stringResource(id = R.string.Order),
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White, // Color del texto
                                fontSize = 18.sp,
                            )
                        }
                    }
                    //Boton para el personal
                    TextButton(
                        onClick = { navController.navigate(AppScreens.Menu.route) },
                        modifier = Modifier
                            .padding(5.dp)
                            .height(48.dp)
                            .background(Color.Black)
                    ) {
                        Row(
                        ) {
                            Icon(imageVector = Icons.Filled.SupervisorAccount, contentDescription = null)
                            Text(
                                text = stringResource(id = R.string.Personal),
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White, // Color del texto
                                fontSize = 18.sp,
                            )
                        }
                    }
                }
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ){
        LazyColumn (modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp, bottom = 50.dp)
        ){
            item{
                Row {
                    Text(text = stringResource(id = R.string.Menu),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 40.sp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    OutlinedTextField(
                        value = Search,
                        onValueChange = {Search = it},
                        label = { Text(text = stringResource(id = R.string.Search)) },
                        placeholder = { Text(text = stringResource(id = R.string.Search)) },
                        leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar") },
                        modifier = Modifier.width(260.dp).height(58.dp)
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
                        modifier = Modifier.size(150.dp)
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
                        modifier = Modifier.size(150.dp)
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(navController: NavController){
    Scaffold {
        DesingMenu(navController)
    }
}