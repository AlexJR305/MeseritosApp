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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FactCheck
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesingBill(navController: NavController){
    Scaffold (
        topBar = {
            TopAppBar(title = {
                Row {
                    IconButton(onClick = { navController.navigate(AppScreens.Menu.route) }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                    Text(
                        text = stringResource(id = R.string.Bill),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            })
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primary
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                ) {
                    //Boton para pagar
                    TextButton(
                        onClick = {  },
                        modifier = Modifier
                            .padding(8.dp)
                            .height(48.dp)
                            .background(Color.Black)
                    ) {
                        Row(
                        ) {
                            Icon(imageVector = Icons.Filled.Payment, contentDescription = null)
                            Text(
                                text = stringResource(id = R.string.Pay),
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White, // Color del texto
                                fontSize = 18.sp,
                            )
                        }
                    }

                    //Boton para cancelar
                    TextButton(
                        onClick = {  navController.navigate(AppScreens.Menu.route)  },
                        modifier = Modifier
                            .padding(8.dp)
                            .height(48.dp)
                            .background(Color.Black)
                    ) {
                        Row(
                        ) {
                            Icon(imageVector = Icons.Filled.Cancel, contentDescription = null)
                            Text(
                                text = stringResource(id = R.string.CancelBill),
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
        //Variables
        var total by remember{ mutableStateOf("") }
        var iva by remember{ mutableStateOf("") }

        val list = listOf("Producto","Costo","Cantidad","Precio")

        Box(
            Modifier
                .padding(top = 60.dp, start = 5.dp, end = 5.dp)
                .fillMaxSize()
        ){
            Column {
                LazyVerticalGrid(columns = GridCells.Fixed(4),
                    content = {
                        items(list.size){ index ->
                            Card (
                                modifier = Modifier.border(1.dp, Color.Black)
                                    .fillMaxWidth()
                                    .padding(start = 3.dp)
                            ){
                                Text(text = list[index],
                                    fontSize = 18.sp,
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }

                        }
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                Column (
                    Modifier.fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                        .padding(end = 30.dp)
                ){
                    Text(text = stringResource(id = R.string.Total) + total,
                        style = MaterialTheme.typography.bodyLarge)

                    Text(text = stringResource(id = R.string.Iva) + iva,
                        style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BillScreen(navController: NavController){
    Scaffold {
        DesingBill(navController)
    }
}