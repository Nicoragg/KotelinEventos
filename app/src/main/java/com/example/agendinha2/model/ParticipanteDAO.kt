package com.example.agendinha2.model


@androidx.room.Dao
interface ParticipanteDao {
    @androidx.room.Query("SELECT * FROM participantes")
    fun listarParticipantes(): kotlinx.coroutines.flow.Flow<List<com.example.agendinha2.model.Participante>>

    @androidx.room.Insert
    suspend fun inserirParticipante(participante: com.example.agendinha2.model.Participante)

    @androidx.room.Update
    suspend fun atualizarParticipante(participante: com.example.agendinha2.model.Participante)

    @androidx.room.Delete
    suspend fun deletarParticipante(participante: com.example.agendinha2.model.Participante)
}