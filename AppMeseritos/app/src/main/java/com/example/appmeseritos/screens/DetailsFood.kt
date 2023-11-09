package com.example.appmeseritos.screens

import android.annotation.SuppressLint
import android.widget.NumberPicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appmeseritos.R
import com.example.appmeseritos.navigation.AppScreens
import com.example.appmeseritos.ui.theme.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun desingDetailsFood(navController: NavController){
    //Variables
    var Num by remember{ mutableStateOf("") }
    val myViewModel = viewModel<MainViewModel>()
    BoxWithConstraints {
        //Adaptacion del tamano de pantallas
        val WidthScreenButton: Int
        val WidthScreenTextFied: Int
        val WidthScreenText: Int
        val WidthScreenPicture: Int
        val WidthScreenTittle: Int
        val WidthScreenBack: Int
        var WidthScreenTextButton: Int
        var WidthScreenIcon : Int
        if (maxWidth < 400.dp) {
            WidthScreenButton = 130
            WidthScreenTextFied = 260
            WidthScreenText = 30
            WidthScreenPicture = 200
            WidthScreenTittle = 25
            WidthScreenBack = 45
            WidthScreenTextButton = 17
            WidthScreenIcon = 24
        } else {
            WidthScreenButton = 260
            WidthScreenTextFied = 500
            WidthScreenText = 60
            WidthScreenPicture = 300
            WidthScreenTittle = 38
            WidthScreenBack = 140
            WidthScreenTextButton = 27
            WidthScreenIcon = 34
        }
        Scaffold (
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Row {
                            IconButton(onClick = { navController.navigate(AppScreens.Menu.route) }) {
                                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null,
                                    modifier = Modifier.size(WidthScreenBack.dp))
                            }
                            Text(
                                text = stringResource(id = R.string.DetailsFood),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                fontSize = WidthScreenTittle.sp
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
                    LazyColumn (
                        Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        item{
                            Image(painter = painterResource(id = R.drawable.captura), contentDescription = "",
                                modifier = Modifier.size(WidthScreenPicture.dp))
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(text = stringResource(id = R.string.DescriptionFood),
                                style = MaterialTheme.typography.titleLarge,
                                fontSize = WidthScreenText.sp)
                            Spacer(modifier = Modifier.height(20.dp))
                        }

                        item{
                            //Seccion de cantidad
                            Text(text = stringResource(id = R.string.HowMany),
                                style = MaterialTheme.typography.titleLarge,
                                fontSize = WidthScreenText.sp)
                            Spacer(modifier = Modifier.height(20.dp))
                            TextField(
                                value = myViewModel.howManyListToOrder.value,
                                onValueChange = {
                                    // Filtrar solo números
                                    val newText = it.filter { it.isDigit() }
                                    Num = myViewModel.sethowManyListToOrder(newText).toString()
                                },
                                label = { Text(text = stringResource(id = R.string.Amount))},
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Number
                                ),
                                textStyle = TextStyle(fontSize = 24.sp),
                                modifier = Modifier.width(WidthScreenTextFied.dp)
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                        item{
                            //Seccion de datos extras
                            Text(text = stringResource(id = R.string.DetailsExtra),
                                style = MaterialTheme.typography.bodyLarge,
                                fontSize = WidthScreenText.sp)
                            Spacer(modifier = Modifier.height(20.dp))
                            TextField(
                                value = myViewModel.extraDetailsListToOrder.value,
                                onValueChange = {
                                        DescriptionFood ->
                                    myViewModel.setextraDetailsListToOrder(DescriptionFood)
                                },
                                label = { Text(text = stringResource(id = R.string.Preferences))},
                                maxLines = 4,
                                modifier = Modifier.width(WidthScreenTextFied.dp)
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                        item{
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
                                        .width(WidthScreenButton.dp)
                                        .background(Color.Black)
                                ) {
                                    Row(
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.RestaurantMenu,
                                            contentDescription = null,
                                            modifier = Modifier.size(WidthScreenIcon.dp)
                                        )
                                        Text(
                                            text = "Confirmar",
                                            style = MaterialTheme.typography.titleLarge,
                                            color = Color.White, // Color del texto
                                            fontSize = WidthScreenTextButton.sp,
                                        )
                                    }
                                }

                                //Boton de cancelacion
                                TextButton(
                                    onClick = { navController.navigate(AppScreens.Menu.route) },
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .height(48.dp)
                                        .width(WidthScreenButton.dp)
                                        .background(Color.Black)
                                ) {
                                    Row(
                                    ) {
                                        Icon(imageVector = Icons.Filled.Cancel, contentDescription = null,
                                            modifier = Modifier.size(WidthScreenIcon.dp))
                                        Text(
                                            text = "Cancelar",
                                            style = MaterialTheme.typography.titleLarge,
                                            color = Color.White, // Color del texto
                                            fontSize = WidthScreenTextButton.sp,
                                        )
                                    }
                                }
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
