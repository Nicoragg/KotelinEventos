package com.example.ktproject

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Kotelin.View.EventosView
import com.example.kotelin.View.ParticipantesView
import com.example.kotelin.ui.theme.KotelinTheme
import com.ti4all.navegacaoemtelas.view.TelaInicial

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotelinTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "Tela 01") {
                    composable(route = "Tela 01") { Iniciar(navController) }
                    composable(route = "Tela 02") { TelaInicial(navController) }
                    composable(route = "Tela 03") { EventosView(navController) }
                    composable(route = "Tela 04") { ParticipantesView(navController) }
                }
            }
        }
    }

}

@Composable
fun Iniciar(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text("Seja bem-vindo",
        fontSize = 30.sp,
        color = Color.Gray,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = "Descubra e organize eventos",
            fontSize = 18.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "incríveis perto de você.",
            fontSize = 18.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                try {
                    navController.navigate("Tela 02")
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
            Text("Entrar", fontSize = 18.sp, color = Color.White)
        }


    }

}