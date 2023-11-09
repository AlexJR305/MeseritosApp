package com.example.appmeseritos.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appmeseritos.R
import com.example.appmeseritos.navigation.AppScreens
import com.example.appmeseritos.ui.theme.AppMeseritosTheme
import com.example.appmeseritos.ui.theme.MainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body(navController: NavController){
    //Variable de ViewModel
    val miViewModel = viewModel<MainViewModel>()

    BoxWithConstraints {
        var WithScreen: Int
        var WidthScreenText: Int
        var WidthScreenTextButton: Int
        var WidthScreenIcon: Int
        if (maxWidth < 400.dp) {
            WithScreen = 118
            WidthScreenText = 20
            WidthScreenTextButton = 17
            WidthScreenIcon = 27
        } else {
            WithScreen = 260
            WidthScreenText = 35
            WidthScreenTextButton = 27
            WidthScreenIcon = 34
        }

        Box(
            modifier = Modifier.fillMaxSize()
        ){
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(top = 8.dp)

            ){

                item{
                    //Valores para No de Control
                    Text(
                        text = "No. Control",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally),
                        fontSize = WidthScreenText.sp
                    )
                    OutlinedTextField(
                        value = miViewModel.userHome.value,
                        onValueChange = {newUser ->
                            miViewModel.setuserHome(newUser)
                        },

                        label = { Text(text = stringResource(id = R.string.User),
                            color = Color.White) },
                        placeholder = { Text(text = stringResource(id = R.string.User),
                            color = Color.White) },
                        leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "Buscar",
                            tint = Color.White ) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp)
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(start = 40.dp, end = 40.dp)
                    )
                }

                item{
                    //Valores para contraseña
                    Text(
                        text = "Contraseña",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally),
                        fontSize = WidthScreenText.sp
                    )
                    OutlinedTextField(
                        value = "*".repeat(miViewModel.passHome.value.length),
                        onValueChange = {password ->
                            miViewModel.setPassHome(password)
                        },
                        label = { Text(text = stringResource(id = R.string.Password),
                            color = Color.White) },
                        placeholder = { Text(text = stringResource(id = R.string.Password),
                            color = Color.White) },
                        leadingIcon = { Icon(imageVector = Icons.Filled.Password, contentDescription = "Buscar",
                            tint = Color.White ) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp)
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(start = 40.dp, end = 40.dp)
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                }
                item{
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        ){
                            //Boton de acceso para chef o admin
                            TextButton(
                                onClick = { navController.navigate(route = AppScreens.ListToOrdersScreen.route) },
                                modifier = Modifier
                                    .padding(8.dp)
                                    .height(48.dp)
                                    .width(WithScreen.dp)
                                    .background(Color.Black)
                            ) {
                                Row(
                                ) {
                                    Icon(imageVector = Icons.Filled.ExitToApp,
                                        contentDescription = null,
                                        modifier = Modifier.padding(start = 8.dp, end = 8.dp).size(WidthScreenIcon.dp))
                                    Text(
                                        text = "Entrar",
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color.White, // Color del texto
                                        fontSize = WidthScreenTextButton.sp,
                                    )
                                }
                            }

                            //Boton de acceso admin se borrara
                            TextButton(
                                onClick = { navController.navigate(route = AppScreens.AdminScreen.route) },
                                modifier = Modifier
                                    .padding(8.dp)
                                    .height(48.dp)
                                    .width(WithScreen.dp)
                                    .background(Color.Black)
                            ) {
                                Row(
                                ) {
                                    Icon(imageVector = Icons.Filled.ExitToApp,
                                        contentDescription = null,
                                        modifier = Modifier.padding(start = 8.dp, end = 8.dp).size(WidthScreenIcon.dp))
                                    Text(
                                        text = "Admin",
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color.White, // Color del texto
                                        fontSize = WidthScreenTextButton.sp,
                                    )
                                }
                            }

                            //Boton de cancelacion para ir al menu para los clientes
                            TextButton(
                                onClick = { navController.navigate(AppScreens.Menu.route) },
                                modifier = Modifier
                                    .padding(8.dp)
                                    .height(48.dp)
                                    .width(WithScreen.dp)
                                    .background(Color.Black)
                            ) {
                                Row(
                                ) {
                                    Icon(imageVector = Icons.Filled.Cancel,
                                        contentDescription = null,
                                        modifier = Modifier.padding(start = 8.dp, end = 8.dp).size(WidthScreenIcon.dp)
                                    )
                                    Text(
                                        text = "Salir",
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color.White, // Color del texto
                                        fontSize = WidthScreenTextButton.sp,
                                    )
                                }
                            }
                        }

                    //Botones

                }

            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    Scaffold {
        Body(navController)
    }
}