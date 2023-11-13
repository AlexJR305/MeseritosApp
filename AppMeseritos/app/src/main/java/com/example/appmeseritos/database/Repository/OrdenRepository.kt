package com.example.appmeseritos.database.Repository

import com.example.appmeseritos.data.database.entities.empleados
import com.example.appmeseritos.data.database.entities.orden
import kotlinx.coroutines.flow.Flow

interface OrdenRepository {
    fun getAllOrdenStream(): Flow<List<orden>>

    fun getOrdenStream(id: Int): Flow<orden?>

    suspend fun insertOrden(item: orden)

    suspend fun deleteOrden(item: orden)

    suspend fun updateOrden(item: orden)
}