package com.example.dayscolor.RoomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RegistroDiaDao {
    @Query("SELECT * FROM RegistroDia")
    fun getAllRegistros(): Flow<List<RegistroDia>>

    @Query("SELECT * FROM RegistroDia WHERE id = :id")
    suspend fun getRegistroById(id: Int): RegistroDia?

    @Insert
    suspend fun insert(registroDia: RegistroDia)

    @Update
    suspend fun update(registroDia: RegistroDia)

    // Função para excluir um registro
    @Delete
    suspend fun delete(registroDia: RegistroDia)
}
