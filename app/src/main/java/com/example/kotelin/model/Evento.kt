package com.example.kotelin.ui.theme.Model

@Entity(tableName = "eventos")
data class Evento(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val descricao: String,
    val dataHora: Long,
    val local: String
)