package com.example.appmeseritos.screens

import android.annotation.SuppressLint
import android.widget.NumberPicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appmeseritos.R
import com.example.appmeseritos.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun desingDetailsFood(navController: NavController){
    //Variables
    var Num by remember{ mutableStateOf("") }
    var DescriptionFood by remember { mutableStateOf("") }

    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Row {
                        IconButton(onClick = { navController.navigate(AppScreens.Menu.route) }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                        }
                        Text(
                            text = stringResource(id = R.string.DetailsFood),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
                        )
                    }
            })
        },
        bottomBar = {
            //Deben ir los iconos de logo de empresa y app
        },
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ){
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp)
            .wrapContentSize(Alignment.Center)){
            Column (
                Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.captura), contentDescription = "",
                    modifier = Modifier.size(200.dp))
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = stringResource(id = R.string.DescriptionFood),
                    style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(20.dp))
                //Seccion de cantidad
                Text(text = stringResource(id = R.string.HowMany),
                    style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = Num,
                    onValueChange = {
                        // Filtrar solo números
                        val newText = it.filter { it.isDigit() }
                        Num = newText
                    },
                    label = { Text(text = stringResource(id = R.string.Amount))},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = TextStyle(fontSize = 24.sp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                //Seccion de datos extras
                Text(text = stringResource(id = R.string.DetailsExtra),
                    style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = DescriptionFood,
                    onValueChange = {
                        DescriptionFood = it
                    },
                    label = { Text(text = stringResource(id = R.string.Preferences))},
                    maxLines = 4
                )
                Spacer(modifier = Modifier.height(20.dp))
                //botones
                //Boton Confirmar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                ){
                    //Boton de acceso para chef o admin
                    TextButton(
                        onClick = {  },
                        modifier = Modifier
                            .padding(8.dp)
                            .height(48.dp)
                            .background(Color.Black)
                    ) {
                        Row(
                        ) {
                            Icon(
                                imageVector = Icons.Filled.RestaurantMenu,
                                contentDescription = null
                            )
                            Text(
                                text = "Confirmar",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White, // Color del texto
                                fontSize = 18.sp,
                            )
                        }
                    }

                    //Boton de cancelacion
                    TextButton(
                        onClick = {  },
                        modifier = Modifier
                            .padding(8.dp)
                            .height(48.dp)
                            .background(Color.Black)
                    ) {
                        Row(
                        ) {
                            Icon(imageVector = Icons.Filled.Cancel, contentDescription = null)
                            Text(
                                text = "Cancelar",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White, // Color del texto
                                fontSize = 18.sp,
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
fun DetailsFood(navController: NavController){
    Scaffold {
        desingDetailsFood(navController)
    }
}
