package com.example.agendadeeventos

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.agendadeeventos.model.entities.Evento
import com.example.agendadeeventos.model.entities.Participante
import com.example.agendadeeventos.view.AddEventoScreen
import com.example.agendadeeventos.view.ErrorScreen
import com.example.agendadeeventos.view.AddParticipanteScreen
import com.example.agendadeeventos.view.DetalhesEventoScreen
import com.example.agendadeeventos.view.EditEventoScreen
import com.example.agendadeeventos.view.EditParticipanteScreen
import com.example.agendadeeventos.view.EventoListScreen
import com.example.agendadeeventos.view.TelaInicialScreen
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    private val eventos = mutableStateListOf<Evento>()
    private val participantes = mutableStateListOf<Participante>()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            const val EVENTO_ID = "eventoId"
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "iniciar") {
                composable("iniciar") { IniciarScreen(navController) }
                composable("telaInicial") { TelaInicialScreen(navController) }
                composable("eventos") {
                    EventoListScreen(
                        eventos = eventos,
                        navController = navController
                    )
                }
                composable("novoEvento") {
                    AddEventoScreen { evento ->
                        eventos.add(evento)
                        navController.navigate("eventos") {
                            popUpTo("eventos") { inclusive = true }
                        }
                    }
                }
                composable(
                    route = "novoParticipante/{$EVENTO_ID}",
                    arguments = listOf(navArgument(EVENTO_ID) { type = NavType.IntType })
                ) { backStackEntry ->
                    val eventoId = backStackEntry.arguments?.getInt(EVENTO_ID)

                    if (eventoId != null) {
                        AddParticipanteScreen(eventoId = eventoId) { participante ->
                            participantes.add(participante)
                            navController.navigate("detalhesEvento/$eventoId")
                        }
                    } else {
                        navController.navigate("errorScreen")
                    }
                }
                composable(
                    route = "editarParticipantes/{$EVENTO_ID}/{participanteId}",
                    arguments = listOf(
                        navArgument(EVENTO_ID) { type = NavType.IntType },
                        navArgument("participanteId") { type = NavType.IntType }
                    )
                ) { backStackEntry ->
                    val eventoId = backStackEntry.arguments?.getInt(EVENTO_ID)
                    val participanteId = backStackEntry.arguments?.getInt("participanteId")
                    val participante = participantes.find { it.id == participanteId && it.eventoId == eventoId }

                    if (participante != null) {
                        EditParticipanteScreen(participante) { participanteEditado ->
                            val index = participantes.indexOfFirst { it.id == participanteId }
                            if (index != -1) {
                                participantes[index] = participanteEditado
                            }
                            navController.navigate("detalhesEvento/$eventoId")
                        }
                    } else {
                        navController.navigate("errorScreen")
                    }
                }
                composable("errorScreen") {
                    ErrorScreen(navController = navController)
                }
                composable(
                    route = "detalhesEvento/{eventoId}",
                    arguments = listOf(navArgument("eventoId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val eventoId = backStackEntry.arguments?.getInt("eventoId")

                    if (eventoId != null) {
                        val evento = eventos.find { it.id == eventoId }
                        if (evento != null) {
                            val eventoParticipantes = participantes.filter { it.eventoId == eventoId }
                            DetalhesEventoScreen(
                                eventoId = eventoId,
                                navController = navController,
                                evento = evento,
                                participantes = eventoParticipantes,
                                onDelete = { id ->
                                    eventos.removeIf { it.id == id }
                                    participantes.removeIf { it.eventoId == id }
                                    navController.popBackStack()
                                },
                                onEdit = { navController.navigate("editarEventos/$eventoId") }
                            )
                        } else {
                            navController.navigate("errorScreen")
                        }
                    } else {
                        navController.navigate("errorScreen") // Redireciona para tela de erro se eventoId for nulo
                    }
                }

                composable(
                    route = "editarEventos/{eventoId}",
                    arguments = listOf(navArgument("eventoId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val eventoId = backStackEntry.arguments?.getInt("eventoId")
                    val evento = eventos.find { it.id == eventoId }

                    if (evento != null) {
                        EditEventoScreen(
                            navController = navController,
                            eventoId = eventoId,
                            evento = evento,
                            onEventoEdited = { eventoEditado ->
                                val index = eventos.indexOfFirst { it.id == eventoId }
                                if (index != -1) {
                                    eventos[index] = eventoEditado
                                }
                                navController.navigate("eventos") {
                                    popUpTo("eventos") { inclusive = true }
                                }
                            }
                        )
                    } else {
                        navController.navigate("errorScreen")
                    }
                }
            }
        }
    }

    @Composable
    fun IniciarScreen(navController: NavController) {
        LaunchedEffect(Unit) {
            delay(1800L)
            navController.navigate("telaInicial")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "EVENT",
                fontSize = 90.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,  // Alterado para branco para se destacar do fundo
                modifier = Modifier
                    .background(
                        Brush.linearGradient(
                            colors = listOf(Color.White, Color.White)
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )

            // Título "PLANNER"
            Text(
                text = "PLANNER",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(4.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}