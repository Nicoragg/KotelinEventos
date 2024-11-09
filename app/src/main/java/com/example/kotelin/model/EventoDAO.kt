package com.example.kotelin.ui.theme.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EventoDao {
    @Insert
    suspend fun inserirEvento(evento: Evento)

    @Query("SELECT * FROM eventos")
    fun getAllEventos(): Flow<List<Evento>>

    @Query("SELECT * FROM eventos ORDER BY dataHora")
    fun listarEventos(): Flow<List<Evento>>

    @Update
    suspend fun atualizarEvento(evento: Evento)

    @Delete
    suspend fun deletarEvento(evento: Evento)
}