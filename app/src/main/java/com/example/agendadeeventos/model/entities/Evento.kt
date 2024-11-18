package com.example.agendadeeventos.model.entities

data class Evento(
    val id: Int = 0,
    val nome: String,
    val descricao: String,
    val data: String,
    val local: String
)