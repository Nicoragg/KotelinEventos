package com.example.agendinha2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@androidx.compose.runtime.Composable
fun Participantes(navController: androidx.navigation.NavHostController) {
    androidx.compose.foundation.layout.Column(
        modifier = androidx.compose.ui.Modifier.fillMaxSize()
            .background(androidx.compose.ui.graphics.Color.DarkGray),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        androidx.compose.material3.Text(
            "Tela de Participantes",
            fontSize = 24.sp,
            color = androidx.compose.ui.graphics.Color.Black
        )

        androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))


    }
}