package com.example.kotelin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotelin.View.EventosView
import com.example.kotelin.View.ParticipantesView
import com.ti4all.navegacaoemtelas.view.TelaInicial

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "start") {

        composable("start") { Iniciar(navController) }
        composable("telaInicial") { TelaInicial(navController) }
        composable("eventos") { EventosView(navController) }
        composable("participantes") { ParticipantesView(navController) }
    }
}


@Composable
fun Iniciar(navController: NavHostController) {

    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(3000L)
        navController.navigate("telaInicial")
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "AGENDA",
            fontSize = 72.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Red,
                    offset = Offset(2f, 1f),
                )
            ),
            modifier = Modifier
                .background(
                    Brush.linearGradient(
                        colors = listOf(Color.White, Color.White)
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(18.dp,6.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "DE EVENTOS",
            fontSize = 46.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Red,
                    offset = Offset(2f, 1f),
                )
            ),
            modifier = Modifier.padding(4.dp),
            textAlign = TextAlign.Center
        )

    }
}


