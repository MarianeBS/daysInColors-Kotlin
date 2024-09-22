package com.example.dayscolor.Factory

import android.content.Context
import com.example.dayscolor.Repository.Repository
import com.example.dayscolor.RoomDB.DaysInColorDatabase


object RegistroDiaViewModelFactoryProvider {
    private lateinit var repository: Repository

    fun initialize(context: Context) {
        val database = DaysInColorDatabase.getDatabase(context)
        repository = Repository(database.registroDiaDao())
    }

    val factory: RegistroDiaViewModelFactory
        get() = RegistroDiaViewModelFactory(repository)
}
