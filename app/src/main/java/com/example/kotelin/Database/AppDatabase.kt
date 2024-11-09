package com.example.Kotelin.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotelin.model.Participante
import com.example.kotelin.model.ParticipanteDao

import com.example.kotelin.ui.theme.Model.Evento
import com.example.kotelin.ui.theme.Model.EventoDao

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