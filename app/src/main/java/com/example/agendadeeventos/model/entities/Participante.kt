package com.example.agendadeeventos.model.entities

data class Participante(
    val id: Int = 0,
    val nome: String,
    val email: String,
    val eventoId: Int
)