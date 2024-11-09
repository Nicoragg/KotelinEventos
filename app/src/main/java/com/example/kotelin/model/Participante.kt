package com.example.kotelin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "participantes")
data class Participante(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val email: String,
    val eventoId: Int // Relaciona com o Evento
)