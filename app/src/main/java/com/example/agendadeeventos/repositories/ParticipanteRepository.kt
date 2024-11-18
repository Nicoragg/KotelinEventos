package com.example.agendadeeventos.repository

import com.example.agendadeeventos.model.entities.Participante

object ParticipanteRepository {

    private val participantes = mutableListOf<Participante>()

    fun getParticipantesByEventoId(eventoId: Int): List<Participante> {
        return participantes.filter { it.eventoId == eventoId }
    }

    fun addParticipante(participante: Participante) {
        participantes.add(participante)
    }

    fun updateParticipante(participante: Participante) {
        val index = participantes.indexOfFirst { it.id == participante.id }
        if (index != -1) {
            participantes[index] = participante
        }
    }

    fun deleteParticipante(id: Int) {
        participantes.removeAll { it.id == id }
    }
}
