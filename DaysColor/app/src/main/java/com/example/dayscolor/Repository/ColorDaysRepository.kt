package com.example.dayscolor.Repository

import com.example.dayscolor.RoomDB.RegistroDia
import com.example.dayscolor.RoomDB.RegistroDiaDao
import kotlinx.coroutines.flow.Flow

class Repository(private val registroDiaDao: RegistroDiaDao) {
    fun getAllRegistros(): Flow<List<RegistroDia>> = registroDiaDao.getAllRegistros()

    suspend fun getRegistroById(id: Int): RegistroDia? = registroDiaDao.getRegistroById(id)

    suspend fun addRegistro(registroDia: RegistroDia) = registroDiaDao.insert(registroDia)

    suspend fun updateRegistro(registroDia: RegistroDia) = registroDiaDao.update(registroDia)

    // Função para excluir um registro
    suspend fun deleteRegistro(registroDia: RegistroDia) = registroDiaDao.delete(registroDia)
}
