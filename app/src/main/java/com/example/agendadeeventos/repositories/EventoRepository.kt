package com.example.agendadeeventos.repository

import com.example.agendadeeventos.model.entities.Evento

object EventoRepository {

    private val eventos = mutableListOf<Evento>()

    fun getAllEventos(): List<Evento> = eventos

    fun getEventoById(id: Int): Evento? = eventos.find { it.id == id }

    fun addEvento(evento: Evento) {
        eventos.add(evento)
    }

    fun updateEvento(evento: Evento) {
        val index = eventos.indexOfFirst { it.id == evento.id }
        if (index != -1) {
            eventos[index] = evento
        }
    }

    fun deleteEvento(id: Int) {
        eventos.removeAll { it.id == id }
    }
}
