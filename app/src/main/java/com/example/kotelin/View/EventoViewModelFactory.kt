package com.example.kotelin.View

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotelin.ui.theme.Model.EventoDao

class EventoViewModelFactory(private val eventoDao: EventoDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EventoViewModel(eventoDao) as T
    }
}