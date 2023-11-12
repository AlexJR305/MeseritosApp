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
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appmeseritos.R
import com.example.appmeseritos.navigation.AppScreens
import com.example.appmeseritos.ui.theme.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun desingNewPerssonel(navController: NavController){
    //Variables
    val miViewModel = viewModel<MainViewModel>()
    var showMessage by remember {
        mutableStateOf(false)
    }
    BoxWithConstraints {
        var WidthScreenTittle: Int
        var WidthScreenBackButton: Int
        var WitdhScreenButtons: Int
        var WitdhScreenTexts: Int
        var WitdhScreenTextF: Int
        var WitdhScreenCombo: Int
        val WidthScreenPicture: Int
        val SpaceWidth: Int
        val SpaceWidthSecond: Int
        var WidthScreenTextButton: Int
        var WidthScreenIcon: Int
        if (maxWidth < 400.dp) {
            WitdhScreenButtons = 130
            WidthScreenTittle = 25
            WidthScreenBackButton = 45
            //Space
            SpaceWidth = 90
            SpaceWidthSecond = 110
            //Image
            WidthScreenPicture = 200
            //TextField
            WitdhScreenTextF = 130
            //Text
            WitdhScreenTexts = 20
            //Combo
            WitdhScreenCombo = 270
            //TextButton
            WidthScreenTextButton = 17
            WidthScreenIcon = 27
        } else {
            WitdhScreenButtons = 300
            WidthScreenTittle = 38
            WidthScreenBackButton = 140
            //Space
            SpaceWidth = 180
            SpaceWidthSecond = 210
            //Image
            WidthScreenPicture = 400
            //TextField
            WitdhScreenTextF = 260
            //Text
            WitdhScreenTexts = 30
            //Combo
            WitdhScreenCombo = 540
            //TextButton
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
                            IconButton(onClick = { navController.navigate(AppScreens.MenuSetting.route) }) {
                                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null,
                                    modifier = Modifier.size(WidthScreenBackButton.dp))
                            }
                            Text(
                                text = stringResource(id = R.string.NewPersonnel),
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
                    //Nombre y apellido
                    item{
                        Column {
                            Row {
                                Text(text = stringResource(id = R.string.NameNewPersonnel),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = WitdhScreenTexts.sp)
                                Spacer(modifier = Modifier.width(SpaceWidth.dp))
                                Text(text = stringResource(id = R.string.LastNameNewPersonnel),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = WitdhScreenTexts.sp)
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Row {
                                TextField(
                                    value = miViewModel.nameNewPerssonel.value,
                                    onValueChange = {
                                            Name ->
                                        miViewModel.setnameNewPerssonel(Name)
                                    },
                                    label = { Text(text = stringResource(id = R.string.NameNewPersonnel))},
                                    modifier = Modifier.width(WitdhScreenTextF.dp),
                                    maxLines = 1
                                )
                                Spacer(modifier = Modifier.width(20.dp))
                                TextField(
                                    value = miViewModel.lastNameNewPerssonel.value,
                                    onValueChange = {
                                            lastName ->
                                        miViewModel.setlastNameNewPerssonel(lastName)
                                    },
                                    label = { Text(text = stringResource(id = R.string.LastNameNewPersonnel))},
                                    modifier = Modifier.width(WitdhScreenTextF.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    //RFC y telefono
                    item{
                        Column {
                            Row {
                                Text(text = stringResource(id = R.string.RfcNewPersonnel),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = WitdhScreenTexts.sp)
                                Spacer(modifier = Modifier.width(SpaceWidthSecond.dp))
                                Text(text = stringResource(id = R.string.PhoneNewPersonnel),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = WitdhScreenTexts.sp)
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Row {
                                TextField(
                                    value = miViewModel.rfcNewPerssonel.value,
                                    onValueChange = {
                                            RFC ->
                                        miViewModel.setrfcNewPerssonel(RFC)
                                    },
                                    label = { Text(text = stringResource(id = R.string.NameNewPersonnel))},
                                    modifier = Modifier.width(WitdhScreenTextF.dp),
                                    maxLines = 1
                                )
                                Spacer(modifier = Modifier.width(20.dp))
                                TextField(
                                    value = miViewModel.phoneNewPerssonel.value,
                                    onValueChange = {
                                            Phone ->
                                        miViewModel.setPhoneNewPerssonel(Phone)
                                    },
                                    keyboardOptions = KeyboardOptions.Default.copy(
                                        keyboardType = KeyboardType.Number
                                    ),
                                    label = { Text(text = stringResource(id = R.string.LastNameNewPersonnel))},
                                    modifier = Modifier.width(WitdhScreenTextF.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    //Puesto
                    item{
                        Column {
                            Text(text = stringResource(id = R.string.JobNewPersonnel),
                                style = MaterialTheme.typography.titleLarge,
                                fontSize = WitdhScreenTexts.sp)
                            Spacer(modifier = Modifier.height(20.dp))
                            // COMBOBOX PARA ESCOGER NOTA O TAREA
                            val items = listOf("Chef", "Mesero")
                            ComboBox(items = items, miViewModel = miViewModel, modifier = Modifier.width(WitdhScreenCombo.dp))
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }

                    //Usuario y contrasena
                    item{
                        Column {
                            Row {
                                Text(text = stringResource(id = R.string.UserNewPersonnel),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = WitdhScreenTexts.sp)
                                Spacer(modifier = Modifier.width(SpaceWidth.dp))
                                Text(text = stringResource(id = R.string.PassNewPersonnel),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = WitdhScreenTexts.sp)
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Row {
                                TextField(
                                    value = miViewModel.userNewPerssonel.value,
                                    onValueChange = {
                                            Name ->
                                        miViewModel.setUserNewPerssonel(Name)
                                    },
                                    label = { Text(text = stringResource(id = R.string.UserNewPersonnel))},
                                    modifier = Modifier.width(WitdhScreenTextF.dp),
                                    maxLines = 1
                                )
                                Spacer(modifier = Modifier.width(20.dp))
                                TextField(
                                    value = miViewModel.passNewPerssonel.value,
                                    onValueChange = {
                                            lastName ->
                                        miViewModel.setPassNewPerssonel(lastName)
                                    },
                                    label = { Text(text = stringResource(id = R.string.PassNewPersonnel))},
                                    modifier = Modifier.width(WitdhScreenTextF.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    //Botones
                    item{
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
                                        imageVector = Icons.Filled.AddCircle,
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
                                onClick = { navController.navigate(AppScreens.PersonnelAdjustments.route) },
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
                            Text(text = "Personal")
                        },
                        text = {
                            Text(text = "Personal agregado/editado con exito")
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    showMessage = false
                                    navController.navigate(AppScreens.PersonnelAdjustments.route)
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
fun NewPerssonel(navController: NavController){
    Scaffold {
        desingNewPerssonel(navController)
    }
}


// COMBOBOX PERSONALIZADO
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComboBox(items: List<String>, miViewModel: MainViewModel, modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {expanded = !expanded}
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = miViewModel.jobNewPerssonel.value,
            onValueChange = {},
            label = { Text("Puesto") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        miViewModel.jobNewPerssonel.value = item
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}