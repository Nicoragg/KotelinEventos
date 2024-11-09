package com.example.kotelin.View

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import com.example.Kotelin.Database.AppDatabase
import com.example.kotelin.ui.theme.Model.Evento
import com.example.kotelin.View.EventoViewModel
import com.example.kotelin.View.EventoViewModelFactory

@Composable
fun EventosView(navController: NavController) {

    val context = LocalContext.current
    val eventoDao = AppDatabase.getDatabase(context).eventoDao()

    // Instanciar o ViewModel usando a ViewModelFactory que recebe o eventoDao
    val viewModel: EventoViewModel = viewModel(factory = EventoViewModelFactory(eventoDao))
    val eventos = viewModel.eventos.collectAsState(initial = emptyList()).value

    Scaffold(
        topBar = {
            Text("Eventos")
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("CreateEvent") }) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar Evento")
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
                    .padding(it),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                eventos.forEach { evento ->
                    EventoItem(evento) {
                        navController.navigate("EventoDetails/${evento.id}")
                    }
                }
            }
        }
    )
}

@Composable
fun EventoItem(evento: Evento, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth().padding(8.dp)
            .clickable(onClick = onClick),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = evento.titulo, fontSize = 18.sp, color = Color.Black)
            Text(text = evento.descricao, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

fun compartilharEvento(context: Context, evento: Evento) {
    val compartilharIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "Evento: ${evento.titulo}")
        putExtra(Intent.EXTRA_TEXT, "Descrição: ${evento.descricao}\nLocal: ${evento.local}\nData e Hora: ${evento.dataHora}")
    }
    context.startActivity(Intent.createChooser(compartilharIntent, "Compartilhar via"))
}
