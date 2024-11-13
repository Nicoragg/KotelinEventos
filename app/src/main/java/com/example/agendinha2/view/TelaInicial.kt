package com.example.agendinha2.view

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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaInicial(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agenda de Eventos", fontSize = 20.sp, color = Color.White) },
                actions = {
                    Button(onClick = { navController.navigate("Tela 05") }) {
                        Icon(Icons.Default.Info, contentDescription = "Info")
                    }
                    Button(onClick = { navController.navigate("Tela 05") }) {
                        Icon(Icons.Default.Info, contentDescription = "Info")
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize().background(Color.DarkGray)
                    .padding(it),
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