package com.example.appmeseritos.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appmeseritos.data.database.dao.empleadosDao
import com.example.appmeseritos.data.database.entities.empleados

@Database(entities = [empleados::class], version = 1)
abstract class meseritosDatabase:RoomDatabase() {

    abstract fun empDao():empleadosDao

    companion object{
        @Volatile
        private var Instance: meseritosDatabase? = null

        fun getDatabase(context: Context): meseritosDatabase{
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, meseritosDatabase::class.java, "meseritos")
                    .build()
                    .also { Instance = it }
            }
        }

    }
}