package com.example.agendadeeventos.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agendadeeventos.model.entities.Evento

@Composable
fun EventoListScreen(eventos: List<Evento>, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize().padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(eventos) { evento ->
                EventoItem(evento = evento, navController = navController)  // Passando o navController para EventoItem
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth().padding(18.dp)
                .shadow(2.dp, shape = RoundedCornerShape(8.dp))
                .background(
                    Color.White,
                ),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextButton(
                onClick = { navController.navigate("novoEvento") },
                modifier = Modifier
                    .weight(2f)
                    .padding(8.dp)
            ) {
                Text(
                    "Novo Evento",
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun EventoItem(evento: Evento, navController: NavController) {  // Adicionando o parâmetro navController aqui
    Card(
        modifier = Modifier
            .fillMaxWidth().padding(8.dp)
            .clickable(onClick = {
                navController.navigate("detalhesEvento/${evento.id}")
            })
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Nome: ${evento.nome}", fontSize = 20.sp)
            Text(text = "Descrição: ${evento.descricao}")
            Text(text = "Data: ${evento.data}")
            Text(text = "Local: ${evento.local}")
        }
    }
}