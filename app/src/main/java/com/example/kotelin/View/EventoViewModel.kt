package com.example.kotelin.View

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kotelin.ui.theme.Model.Evento
import com.example.kotelin.ui.theme.Model.EventoDao
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EventoViewModel(private val eventoDao: EventoDao) : ViewModel() {

    val eventos: StateFlow<List<Evento>> = eventoDao.getAllEventos()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun adicionarEvento(evento: Evento) {
        viewModelScope.launch {
            eventoDao.inserirEvento(evento)
        }
    }

    fun atualizarEvento(evento: Evento) {
        viewModelScope.launch { eventoDao.atualizarEvento(evento) }
    }

    fun deletarEvento(evento: Evento) {
        viewModelScope.launch { eventoDao.deletarEvento(evento) }
    }
}
