package com.example.agendinha2.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@androidx.compose.runtime.Composable
fun Info(navController: androidx.navigation.NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Informações do Sistema",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Criadores:",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Nicolas de Souza\nLaura de Almeida\nWeslley Severino",
            fontSize = 20.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Ano: 2024",
            fontSize = 20.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Versão: 4.6",
            fontSize = 20.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
    }
}