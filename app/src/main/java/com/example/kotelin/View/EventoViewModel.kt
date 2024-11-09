package com.example.kotelin.View

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kotelin.ui.theme.Model.Evento
import com.example.kotelin.ui.theme.Model.EventoDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EventoViewModel(private val eventoDao: EventoDao) : ViewModel() {

    val eventos: LiveData<List<Evento>> = eventoDao.listarEventos().asLiveData()

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

class EventoViewModelFactory(private val eventoDao: EventoDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EventoViewModel(eventoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}