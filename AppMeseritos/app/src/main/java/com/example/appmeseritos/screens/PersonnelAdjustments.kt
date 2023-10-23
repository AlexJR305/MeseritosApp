package com.example.appmeseritos.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appmeseritos.R
import com.example.appmeseritos.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PersonnelAdjustmentsScreen(navController: NavController){
    Scaffold {
        DesingPersonnelAdjustments(navController)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesingPersonnelAdjustments(navController: NavController){
    //Variables
    var Search by remember{ mutableStateOf("") }

    Scaffold (
        topBar = {
            TopAppBar(title = {
                Row {
                    IconButton(onClick = { navController.navigate(AppScreens.AdminScreen.route) }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                    Text(
                        text = stringResource(id = R.string.MenuSettingText),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            })
        },
        bottomBar = {
            BottomAppBar (
                containerColor = MaterialTheme.colorScheme.primary
            ){
                Row (
                    Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                ){
                    //Boton Personal
                    TextButton(
                        onClick = { },
                        modifier = Modifier
                            .padding(5.dp)
                            .height(48.dp)
                            .background(Color.Black)
                    ) {
                        Row(
                        ) {
                            Icon(imageVector = Icons.Filled.AddCircle, contentDescription = null)
                            Text(
                                text = stringResource(id = R.string.MenuSettingAdd),
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White, // Color del texto
                                fontSize = 18.sp,
                            )
                        }
                    }
                    //Boton Menu
                    TextButton(
                        onClick = {  },
                        modifier = Modifier
                            .padding(5.dp)
                            .height(48.dp)
                            .background(Color.Black)
                    ) {
                        Row(
                        ) {
                            Icon(imageVector = Icons.Filled.Edit, contentDescription = null)
                            Text(
                                text = stringResource(id = R.string.MenuSettingEdit),
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White, // Color del texto
                                fontSize = 18.sp,
                            )
                        }
                    }
                    //Boton Salir
                    TextButton(
                        onClick = { navController.navigate(AppScreens.Menu.route) },
                        modifier = Modifier
                            .padding(5.dp)
                            .height(48.dp)
                            .background(Color.Black)
                    ) {
                        Row(
                        ) {
                            Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
                            Text(
                                text = stringResource(id = R.string.MenuSettingDelete),
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White, // Color del texto
                                fontSize = 18.sp,
                            )
                        }
                    }
                }
            }
        }
    ){
        Box(
            Modifier
                .padding(top = 60.dp,start = 5.dp, end = 5.dp)
                .fillMaxSize()
        ){
            var headerList = listOf("Nombre","RFC","Tel","Puesto")

            Column(Modifier.fillMaxSize()){
                OutlinedTextField(
                    value = Search,
                    onValueChange = {Search = it},
                    label = { Text(text = stringResource(id = R.string.Search),
                        color = Color.White) },
                    placeholder = { Text(text = stringResource(id = R.string.Search),
                        color = Color.White) },
                    leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar",
                        tint = Color.White ) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp)
                        .background(MaterialTheme.colorScheme.primary)
                )

                Spacer(modifier = Modifier.height(5.dp))

                LazyVerticalGrid(columns = GridCells.Fixed(4),
                    content = {

                        items(headerList.size){index ->
                            Card (
                                modifier = Modifier
                                    .border(1.dp, Color.Black)
                                    .fillMaxWidth()
                                    .padding(start = 3.dp)
                            ){
                                Text(text = headerList[index],
                                    fontSize = 18.sp,
                                    style = MaterialTheme.typography.titleLarge,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                )
            }

        }
    }
}