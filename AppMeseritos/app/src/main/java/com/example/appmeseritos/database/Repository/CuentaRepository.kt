package com.example.appmeseritos.database.Repository

import com.example.appmeseritos.data.database.entities.cuenta
import com.example.appmeseritos.data.database.entities.empleados
import kotlinx.coroutines.flow.Flow

interface CuentaRepository {
    fun getAllCuentaStream(): Flow<List<cuenta>>

    fun getCuentaStream(id: Int): Flow<cuenta?>

    suspend fun insertCuenta(item: cuenta)

    suspend fun deleteCuenta(item: cuenta)

    suspend fun updateCuenta(item: cuenta)
}