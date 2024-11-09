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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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

    // val image: Painter = painterResource(id = )

    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(3000L)
        navController.navigate("Tela 02")
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        /*
        Image(
            painter = image,
            contentDescription = "Descrição da imagem",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Defina o tamanho da imagem
        )
        */

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

