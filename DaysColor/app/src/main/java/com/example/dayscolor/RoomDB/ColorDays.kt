package com.example.dayscolor.RoomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RegistroDia")
data class RegistroDia(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val data: String,
    val cor: String,
    val motivo: String,
    val avaliacao: Float
)
