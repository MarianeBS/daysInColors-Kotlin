package com.example.dayscolor.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RegistroDia::class], version = 1)
abstract class DaysInColorDatabase : RoomDatabase() {
    abstract fun registroDiaDao(): RegistroDiaDao

    companion object {
        @Volatile
        private var INSTANCE: DaysInColorDatabase? = null

        fun getDatabase(context: Context): DaysInColorDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DaysInColorDatabase::class.java,
                    "days_in_color_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
