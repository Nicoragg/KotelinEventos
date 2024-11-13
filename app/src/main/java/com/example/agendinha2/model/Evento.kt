package com.example.agendinha2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "eventos")
data class Evento(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val descricao: String,
    val dataHora: Long,
    val local: String
)