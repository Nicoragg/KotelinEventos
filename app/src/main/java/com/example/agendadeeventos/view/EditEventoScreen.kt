package com.example.agendadeeventos.view

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agendadeeventos.model.entities.Evento

@Composable
fun EditEventoScreen(
    navController: NavController,
    eventoId: Int,
    evento: Evento,
    onEventoEdited: (Evento) -> Unit
) {
    var nome by remember { mutableStateOf(evento.nome) }
    var descricao by remember { mutableStateOf(evento.descricao) }
    var data by remember { mutableStateOf(evento.data) }
    var local by remember { mutableStateOf(evento.local) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Editar Evento", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = nome,
            onValueChange = { nome = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(10.dp)) { innerTextField() }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Nome do Evento", fontSize = 16.sp)

        BasicTextField(
            value = descricao,
            onValueChange = { descricao = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(10.dp)) { innerTextField() }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Descrição", fontSize = 16.sp)

        BasicTextField(
            value = data,
            onValueChange = { data = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(10.dp)) { innerTextField() }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Data", fontSize = 16.sp)

        BasicTextField(
            value = local,
            onValueChange = { local = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(10.dp)) { innerTextField() }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Local", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val eventoEditado = evento.copy(
                    nome = nome,
                    descricao = descricao,
                    data = data,
                    local = local
                )
                onEventoEdited(eventoEditado)
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar Alterações")
        }
    }
}
