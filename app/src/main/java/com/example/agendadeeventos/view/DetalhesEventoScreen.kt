package com.example.agendadeeventos.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agendadeeventos.model.entities.Evento
import com.example.agendadeeventos.model.entities.Participante

@Composable
fun DetalhesEventoScreen(
    eventoId: Int,
    navController: NavController,
    evento: Evento,
    participantes: List<Participante>,
    onDelete: (Int) -> Unit,
    onEdit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Detalhes do Evento", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        // Exibindo os detalhes do evento
        Text(text = "Nome: ${evento.nome}", fontSize = 20.sp, modifier = Modifier.padding(top = 8.dp))
        Text(text = "Descrição: ${evento.descricao}", modifier = Modifier.padding(top = 8.dp))
        Text(text = "Data: ${evento.data}", modifier = Modifier.padding(top = 8.dp))
        Text(text = "Local: ${evento.local}", modifier = Modifier.padding(top = 8.dp))

        // Exibindo participantes
        Text(text = "Participantes", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 16.dp))
        LazyColumn {
            items(participantes) { participante ->
                ParticipanteItemCard(participante = participante)
            }
        }

        // Botões de ação
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = { onDelete(evento.id) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Excluir Evento", color = Color.White)
            }

            Button(
                onClick = onEdit,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Editar Evento", color = Color.White)
            }
        }

        // Navegação para adicionar participante
        Button(
            onClick = { navController.navigate("novoParticipante/$eventoId") },
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("Adicionar Participante", color = Color.White)
        }
    }
}

@Composable
fun ParticipanteItemCard(participante: Participante) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Nome: ${participante.nome}", fontSize = 16.sp)
            Text(text = "Email: ${participante.email}", fontSize = 16.sp)
        }
    }
}