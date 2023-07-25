package com.pisiitech.materialdesign

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pisiitech.materialdesign.ui.theme.MaterialDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SayfaSabitListeleme()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialDesignTheme {
        SayfaSabitListeleme()
    }
}

@Composable
fun SayfaSabitListeleme() {

    LazyColumn {
        item {
            Card(modifier = Modifier
                .padding(all = 5.dp)
                .fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth().clickable {
                    Log.e("Liste","Gunes tiklandi")
                }) {//tiklama islemini saglayacak bir yapi (row ondan koyduk)
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)) {
                        Image(painter = painterResource(id = R.drawable.gunes_resim_24), contentDescription = "")
                        Text(text = "Gunes", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
        item {
            Card(modifier = Modifier
                .padding(all = 5.dp)
                .fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth().clickable {
                    Log.e("Liste","Ay tiklandi")
                }) {//tiklama islemini saglayacak bir yapi (row ondan koyduk)
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)) {
                        Image(painter = painterResource(id = R.drawable.ay_resim), contentDescription = "")
                        Text(text = "Ay", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun SayfaCard() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Card(modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Blue),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            border = BorderStroke(2.dp, Color.Magenta)
            ) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.clickable {
                Log.e("Card","Tiklandi")
            })  {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth()) {
                    Image(painter = painterResource(id = R.drawable.gunes_resim), contentDescription = "")
                    Text(text = "Gunes", color = Color.White, fontSize = 36.sp)
                    }
                }
            }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SayfaTopAppBarArama() {
    val aramaYapiliyorMu = remember { mutableStateOf(false) }
    val tf = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if(aramaYapiliyorMu.value){
                        TextField(
                            value = tf.value,
                            onValueChange = {
                                tf.value = it
                                Log.e("TopBar", "Arama : $it")
                        },
                        label = { Text(text = "Ara")},
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent, //Arkaplan rengi
                            focusedIndicatorColor = Color.White, // Secildiginde belirtec rengi
                            unfocusedIndicatorColor = Color.White, // Secilmediginde belirtec rengi
                            textColor = Color.Black, //Yazi rengi
                        )
                            )
                    }else{
                        Text(text = "Baslik")
                    }
                },
                actions = {
                    if(aramaYapiliyorMu.value){
                        IconButton(onClick = {
                            aramaYapiliyorMu.value = false
                            tf.value = ""
                        }) {
                            Icon(painter = painterResource(id = R.drawable.kapat_resim),
                                contentDescription = "")
                        }
                    }else{
                        IconButton(onClick = {
                            aramaYapiliyorMu.value = true
                        }) {
                            Icon(painter = painterResource(id = R.drawable.arama_resim),
                                contentDescription = "")
                        }
                    }
                }

                )
            },
        content = {

        }
    )
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SayfaTopAppBar() {
    val menuAcilisKontrol = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(text = "Baslik")
                        Text(text = "Alt Baslik", fontSize = 12.sp)
                        }
                    },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.anaRenk),
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                actions = {
                    Text(text = "Cikis",
                        modifier = Modifier.clickable { Log.e("TopBar", "Cikis secildi") })
                    IconButton(onClick = {
                        Log.e("TopBar", "Info secildi")
                    }) {
                        Icon(painter = painterResource(id = R.drawable.info_resim),
                            contentDescription = "")
                    }
                    IconButton(onClick = {
                        menuAcilisKontrol.value = true
                    }) {
                        Icon(painter = painterResource(id = R.drawable.more_resim),
                            contentDescription = "")
                    }
                    DropdownMenu(
                        expanded = menuAcilisKontrol.value,
                        onDismissRequest = { menuAcilisKontrol.value = false }) {
                        DropdownMenuItem(
                            text = { Text(text = "Sil")},
                            onClick = {
                                Log.e("TopBar", "Menu Sil secildi")
                                menuAcilisKontrol.value = false
                            })
                        DropdownMenuItem(
                            text = { Text(text = "Guncelle")},
                            onClick = {
                                Log.e("TopBar", "Menu Guncelle secildi")
                                menuAcilisKontrol.value = false
                            })
                        
                    }
                }
            )
        },
        content = {

        }
    )
}

