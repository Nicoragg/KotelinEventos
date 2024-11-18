package com.example.agendadeeventos

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.agendadeeventos.model.entities.Evento
import com.example.agendadeeventos.model.entities.Participante

class EventoViewModel(context: Context) : ViewModel() {
    private val sharedPreferences = context.getSharedPreferences("eventosPrefs", Context.MODE_PRIVATE)

    private val _eventos = mutableStateOf<List<Evento>>(emptyList())
    val eventos: State<List<Evento>> = _eventos

    private val _participantes = mutableStateOf<List<Participante>>(emptyList())
    val participantes: State<List<Participante>> = _participantes

    private var nextEventoId = sharedPreferences.getInt("nextEventoId", 1)
    private var nextParticipanteId = sharedPreferences.getInt("nextParticipanteId", 1)

    fun addEvento(evento: Evento) {
        val eventoComId = evento.copy(id = nextEventoId)
        _eventos.value = _eventos.value + eventoComId
        nextEventoId++
        sharedPreferences.edit().putInt("nextEventoId", nextEventoId).apply()
    }

    fun addParticipante(participante: Participante) {
        val participanteComId = participante.copy(id = nextParticipanteId)
        _participantes.value = _participantes.value + participanteComId
        nextParticipanteId++
        sharedPreferences.edit().putInt("nextParticipanteId", nextParticipanteId).apply()
    }

    fun removeEvento(id: Int) {
        _eventos.value = _eventos.value.filter { it.id != id }
        _participantes.value = _participantes.value.filter { it.eventoId != id }
    }

    fun removeParticipante(id: Int) {
        _participantes.value = _participantes.value.filter { it.id != id }
    }
}
