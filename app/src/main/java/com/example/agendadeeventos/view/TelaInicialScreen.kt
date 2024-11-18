package com.example.agendadeeventos.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agendadeeventos.R // Importe o pacote de recursos da sua app

@Composable
fun TelaInicialScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.backgrounds), // Substitua pelo seu recurso de imagem
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x99000000))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(370.dp))
            Text(
                text = "Bem-vindo ao Event Planner",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 32.dp),
                textAlign = TextAlign.Center,
                )
            Button(
                onClick = { navController.navigate("eventos") },
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Entrar",
                    color = Color.White,
                    fontSize = 25.sp
                )
            }
        }
    }
}
