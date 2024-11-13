package com.example.Kotelin.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.agendinha2.model.Evento
import com.example.agendinha2.model.EventoDao
import com.example.agendinha2.model.Participante
import com.example.agendinha2.model.ParticipanteDao


@Database(entities = [Evento::class, Participante::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventoDao(): EventoDao
    abstract fun participanteDao(): ParticipanteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}