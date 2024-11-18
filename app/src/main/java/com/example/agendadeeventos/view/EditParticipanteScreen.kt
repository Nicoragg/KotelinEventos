package com.example.agendadeeventos.view
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agendadeeventos.model.entities.Participante

@Composable
fun EditParticipanteScreen(participante: Participante, onSave: (Participante) -> Unit) {
    val nome = remember { mutableStateOf(participante.nome) }
    val email = remember { mutableStateOf(participante.email) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Editar Participante",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        TextField(
            value = nome.value,  // Acesse o valor do nome
            onValueChange = { nome.value = it },  // Atualize o valor do nome
            label = { Text("Nome do Participante") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        TextField(
            value = email.value,  // Acesse o valor do email
            onValueChange = { email.value = it },  // Atualize o valor do email
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Button(
            onClick = {
                val participanteEditado = participante.copy(nome = nome.value, email = email.value)
                onSave(participanteEditado) // Salva as alterações
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("Salvar Alterações", color = Color.White)
        }
    }
}