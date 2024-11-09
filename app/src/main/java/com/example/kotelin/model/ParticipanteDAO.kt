package com.example.kotelin.model
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface ParticipanteDao {
    @Query("SELECT * FROM participantes")
    fun listarParticipantes(): Flow<List<Participante>>

    @Insert
    suspend fun inserirParticipante(participante: Participante)

    @Update
    suspend fun atualizarParticipante(participante: Participante)

    @Delete
    suspend fun deletarParticipante(participante: Participante)
}