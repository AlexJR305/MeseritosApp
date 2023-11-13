package com.example.appmeseritos.database.Repository

import com.example.appmeseritos.data.database.entities.comida
import com.example.appmeseritos.data.database.entities.empleados
import kotlinx.coroutines.flow.Flow

interface ComidaRepository {
    fun getAllComidaStream(): Flow<List<comida>>

    fun getComidaStream(id: Int): Flow<comida?>

    suspend fun insertComida(item: comida)

    suspend fun deleteComida(item: comida)

    suspend fun updateComida(item: comida)
}