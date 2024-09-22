package com.example.dayscolor.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dayscolor.Repository.Repository
import com.example.dayscolor.RoomDB.RegistroDia
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class RegistroDiaViewModel(private val repository: Repository) : ViewModel() {
    fun getAllRegistros(): Flow<List<RegistroDia>> = repository.getAllRegistros()

    suspend fun getRegistroById(id: Int): RegistroDia? {
        return repository.getRegistroById(id)
    }

    fun addRegistro(registroDia: RegistroDia) {
        viewModelScope.launch {
            repository.addRegistro(registroDia)
        }
    }

    fun updateRegistro(registroDia: RegistroDia) {
        viewModelScope.launch {
            repository.updateRegistro(registroDia)
        }
    }

    // Função para excluir um registro
    fun deleteRegistro(registroDia: RegistroDia) {
        viewModelScope.launch {
            repository.deleteRegistro(registroDia)
        }
    }
}
