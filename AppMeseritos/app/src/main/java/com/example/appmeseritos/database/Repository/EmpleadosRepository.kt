package com.example.appmeseritos.database.Repository

import com.example.appmeseritos.data.database.entities.empleados
import kotlinx.coroutines.flow.Flow

interface EmpleadosRepository {
    fun getAllEmpleadosStream(): Flow<List<empleados>>

    fun getEmpleadoStream(id: Int): Flow<empleados?>

    suspend fun insertEmpleado(item: empleados)

    suspend fun deleteEmpleado(item: empleados)

    suspend fun updateEmpleado(item: empleados)
}