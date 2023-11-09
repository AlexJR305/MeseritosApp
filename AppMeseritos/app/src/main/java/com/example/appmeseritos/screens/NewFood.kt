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
import androidx.compose.material3.AlertDialog
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
fun desingNewFood(navController: NavController){
    //Variables
    val myViewModel = viewModel<MainViewModel>()
    var showMessage by remember {
        mutableStateOf(false)
    }

    BoxWithConstraints {
        var WidthScreenTittle: Int
        var WidthScreenBackButton: Int
        var WitdhScreenButtons: Int
        val WidthScreenPicture: Int
        var WitdhScreenTextFName: Int
        var WitdhScreenTextFCount: Int
        var WitdhScreenTextFDescription: Int
        var WitdhScreenTexts: Int
        var SpaceWidth: Int
        var WidthScreenTextButton : Int
        var WidthScreenIcon : Int
        if (maxWidth < 400.dp) {
            WidthScreenIcon = 27
            WitdhScreenButtons = 130
            WidthScreenTittle = 25
            WidthScreenBackButton = 45
            WidthScreenTextButton = 17
            //Space
            SpaceWidth = 120
            //Image
            WidthScreenPicture = 200
            //TextField
            WitdhScreenTextFName = 150
            WitdhScreenTextFCount = 100
            WitdhScreenTextFDescription = 235
            //Text
            WitdhScreenTexts = 20
        } else {
            WidthScreenIcon = 34
            //BottomBar
            WitdhScreenButtons = 300
            //TopBar
            WidthScreenTittle = 38
            WidthScreenBackButton = 140
            WidthScreenTextButton = 27
            //Space
            SpaceWidth = 240
            //Image
            WidthScreenPicture = 300
            //TextField
            WitdhScreenTextFName = 300
            WitdhScreenTextFCount = 200
            WitdhScreenTextFDescription = 470
            //Text
            WitdhScreenTexts = 30
        }
        Scaffold (
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Row {
                            IconButton(onClick = { navController.navigate(AppScreens.MenuSetting.route) }) {
                                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null,
                                    modifier = Modifier.size(WidthScreenBackButton.dp))
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
                    }
                    item{
                        Column {
                            Row {
                                Text(text = stringResource(id = R.string.AddFood),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = WitdhScreenTexts.sp)
                                Spacer(modifier = Modifier.width(SpaceWidth.dp))
                                Text(text = stringResource(id = R.string.PriceFood),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = WitdhScreenTexts.sp)
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Row {
                                TextField(
                                    value = myViewModel.NameNewFood.value,
                                    onValueChange = {
                                            AddNewFood ->
                                        myViewModel.setNameNewFood(AddNewFood)
                                    },
                                    label = { Text(text = stringResource(id = R.string.AddFood))},
                                    modifier = Modifier.width(WitdhScreenTextFName.dp)
                                )
                                Spacer(modifier = Modifier.width(20.dp))
                                TextField(
                                    value = myViewModel.CountNewFood.value,
                                    onValueChange = {
                                            count ->
                                        myViewModel.setCountNewFood(count)
                                    },
                                    keyboardOptions = KeyboardOptions.Default.copy(
                                        keyboardType = KeyboardType.Number
                                    ),
                                    label = { Text(text = stringResource(id = R.string.PriceFood))},
                                    modifier = Modifier.width(WitdhScreenTextFCount.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    item{
                        //Seccion de datos extras
                        Text(text = stringResource(id = R.string.DescriptionNewFood),
                            style = MaterialTheme.typography.titleLarge,
                            fontSize = WitdhScreenTexts.sp)
                        Spacer(modifier = Modifier.height(20.dp))
                        TextField(
                            value = myViewModel.DescriptionNewFood.value,
                            onValueChange = {
                                    description ->
                                myViewModel.setDescriptionNewFood(description)
                            },
                            label = { Text(text = stringResource(id = R.string.Preferences))},
                            maxLines = 4,
                            modifier = Modifier.width(WitdhScreenTextFDescription.dp)
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
                                onClick = { showMessage  = true },
                                modifier = Modifier
                                    .padding(8.dp)
                                    .height(48.dp)
                                    .width(WitdhScreenButtons.dp)
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
                                onClick = { navController.navigate(AppScreens.MenuSetting.route) },
                                modifier = Modifier
                                    .padding(8.dp)
                                    .height(48.dp)
                                    .width(WitdhScreenButtons.dp)
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
                if(showMessage){
                    AlertDialog(
                        onDismissRequest = {
                            // Manejar el evento de descartar
                            showMessage = false
                        },
                        title = {
                            Text(text = "Nuevo platillo")
                        },
                        text = {
                            Text(text = "Producto agregado con exito")
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    showMessage = false
                                    navController.navigate(AppScreens.MenuSetting.route)
                                }
                            ) {
                                Text("Confirmar")
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = {
                                    showMessage = false
                                }
                            ) {
                                Text("Cancelar")
                            }
                        }
                    )
                }
            }
        }
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewFood(navController: NavController){
    Scaffold {
        desingNewFood(navController)
    }
}
