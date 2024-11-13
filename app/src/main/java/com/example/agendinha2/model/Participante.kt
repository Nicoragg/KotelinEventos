package com.example.agendinha2.model

@androidx.room.Entity(tableName = "participantes")
data class Participante(
    @androidx.room.PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val email: String,
    val eventoId: Int // Relaciona com o Evento
)