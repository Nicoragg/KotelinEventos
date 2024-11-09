package com.ti4all.navegacaoemtelas.view
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun TelaInicial(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("EventApp", fontSize = 20.sp, color = Color.White) },
                backgroundColor = Color(0xFF6200EE),
                contentColor = Color.White,
                actions = {
                    IconButton(onClick = { navController.navigate("Tela 03") }) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favoritos")
                    }
                    IconButton(onClick = { navController.navigate("Tela 04") }) {
                        Icon(Icons.Default.Home, contentDescription = "Home")
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
                    .padding(it), // Para garantir que o conteúdo não sobreponha a TopAppBar
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Descubra e organize eventos",
                    fontSize = 18.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = "incríveis perto de você.",
                    fontSize = 18.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        try {
                            navController.navigate("Tela 03")
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
                ) {
                    Text("Eventos", fontSize = 18.sp, color = Color.White)
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        try {
                            navController.navigate("Tela 04")
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
                ) {
                    Text("Participantes", fontSize = 18.sp, color = Color.White)
                }
            }
        }
    )
}